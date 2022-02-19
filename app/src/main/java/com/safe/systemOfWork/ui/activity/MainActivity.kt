package com.safe.systemOfWork.ui.activity

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.safe.systemOfWork.R
import com.safe.systemOfWork.helper.interfaces.ItemClickWithObjectListener
import com.safe.systemOfWork.model.Conversation
import com.safe.systemOfWork.ui.adapter.HistoryAdapter
import com.safe.systemOfWork.utils.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var historyAdapter: HistoryAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var convList: ArrayList<Conversation> = ArrayList()
    private val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        clickListener()
        //getDataFromFirestore()
    }

    override fun onResume() {
        super.onResume()
        getDataFromFirestore()
    }

    private fun clickListener() {
        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                var con = intent?.getSerializableExtra("CONVERSATION") as Conversation
                convList.add(con)
                historyAdapter.notifyDataSetChanged()
                saveDataToFirestore(con)
            }
        }
        fab.setOnClickListener {
            var intent = Intent(this@MainActivity, AddConversationActivity::class.java)
            startForResult.launch(intent)
        }
    }

    private fun saveDataToFirestore(conversation: Conversation) {

        val con = Data.convertDataToHashMap(conversation)

        db.collection("conversations")
            .add(con)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }


    private fun getDataFromFirestore() {
        convList.clear()
        db.collection("conversations")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    convList.add(0, Conversation.mapToObject(document.data, document.id))
                }
                if (convList.isEmpty()) {
                    textViewNoItems.visibility = View.VISIBLE
                } else {
                    textViewNoItems.visibility = View.GONE
                }
                historyAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }


    private fun setAdapter() {
        historyAdapter = HistoryAdapter(this, convList, object : ItemClickWithObjectListener {
            override fun onItemClickObject(item: Any?) {
                val con = item as Conversation
                var intent = Intent(this@MainActivity, DetailConversationActivity::class.java)
                intent.putExtra("CONVERSATION", con)
                startActivity(intent)
            }

        })
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        conversationRV.layoutManager = linearLayoutManager
        conversationRV.adapter = historyAdapter
    }

}