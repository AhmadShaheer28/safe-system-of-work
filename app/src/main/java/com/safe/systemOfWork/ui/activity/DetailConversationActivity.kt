package com.safe.systemOfWork.ui.activity

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.safe.systemOfWork.R
import com.safe.systemOfWork.model.Conversation
import kotlinx.android.synthetic.main.activity_detail_conversation.*
import kotlinx.android.synthetic.main.activity_detail_conversation.causeOfUnsafeET
import kotlinx.android.synthetic.main.activity_detail_conversation.commentET
import kotlinx.android.synthetic.main.activity_detail_conversation.dateET
import kotlinx.android.synthetic.main.activity_detail_conversation.manualSafeTV
import kotlinx.android.synthetic.main.activity_detail_conversation.manualUnSafeTV
import kotlinx.android.synthetic.main.activity_detail_conversation.nameObservedET
import kotlinx.android.synthetic.main.activity_detail_conversation.observerNameET
import kotlinx.android.synthetic.main.activity_detail_conversation.officeTV
import kotlinx.android.synthetic.main.activity_detail_conversation.safeTV
import kotlinx.android.synthetic.main.activity_detail_conversation.siteET
import kotlinx.android.synthetic.main.activity_detail_conversation.taskObservedET
import kotlinx.android.synthetic.main.activity_detail_conversation.timeET

class DetailConversationActivity : AppCompatActivity() {

    lateinit var conversation: Conversation
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_conversation)

        conversation = intent.getSerializableExtra("CONVERSATION") as Conversation

        populateConversationData()
        clickListener()
    }

    private fun clickListener() {
        deleteConversation.setOnClickListener {
            showAlert(this, "Alert", "Are you sure you want to delete this safety conversation?")
        }
    }

    private fun showAlert(context: Context?, title: String?, message: String?) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(
                "No"
            ) { dialog, _ -> dialog.dismiss() }
            .setPositiveButton(
                "Yes"
            ) { _, _ -> deleteConversation() }
            .show()
    }

    private fun deleteConversation() {
        db.collection("conversations").document(conversation.id).delete()
        finish()
    }



    private fun populateConversationData() {
        dateET.text = conversation.date
        timeET.text = conversation.time
        siteET.text = conversation.site
        observerNameET.text = conversation.observerName
        officeTV.text = conversation.whereObserved
        nameObservedET.text = conversation.personObservedName
        taskObservedET.text = conversation.taskObserved
        safeBehaviourTV.text = conversation.behaviourObserved
        causeOfUnsafeET.text = conversation.causeOfUnsafe
        commentET.text = conversation.comment
        actionCodeVal.text = conversation.actionCode


        if (conversation.behaviourCodes.manualHandle.toInt() > 4) {
            manualUnSafeTV.text = conversation.behaviourCodes.manualHandle
            manualSafeTV.text = ""
        } else {
            manualUnSafeTV.text = ""
            manualSafeTV.text = conversation.behaviourCodes.manualHandle
        }

        if (conversation.behaviourCodes.PPE.toInt() > 2) {
            ppeUnSafeTV.text = conversation.behaviourCodes.PPE
            ppeSafeTV.text = ""
        } else {
            ppeUnSafeTV.text = ""
            ppeSafeTV.text = conversation.behaviourCodes.PPE
        }

        if (conversation.behaviourCodes.MHE.toInt() > 9) {
            mheUnSafeTV.text = conversation.behaviourCodes.MHE
            mheSafeTV.text = ""
        } else {
            mheUnSafeTV.text = ""
            mheSafeTV.text = conversation.behaviourCodes.MHE
        }

        if (conversation.behaviourCodes.workplace.toInt() > 5) {
            workplaceUnSafeTV.text = conversation.behaviourCodes.workplace
            workplaceSafeTV.text = ""
        } else {
            workplaceUnSafeTV.text = ""
            workplaceSafeTV.text = conversation.behaviourCodes.workplace
        }

        if (conversation.behaviourCodes.workEquipment.toInt() > 4) {
            workEquipUnSafeTV.text = conversation.behaviourCodes.workEquipment
            workEquipSafeTV.text = ""
        } else {
            workEquipUnSafeTV.text = ""
            workEquipSafeTV.text = conversation.behaviourCodes.workEquipment
        }

        if (conversation.behaviourCodes.roadTransport.toInt() > 4) {
            roadTransUnSafeTV.text = conversation.behaviourCodes.roadTransport
            roadTransSafeTV.text = ""
        } else {
            roadTransUnSafeTV.text = ""
            roadTransSafeTV.text = conversation.behaviourCodes.roadTransport
        }

        if (conversation.behaviourCodes.procedure.toInt() > 4) {
            procedureUnSafeTV.text = conversation.behaviourCodes.procedure
            procedureSafeTV.text = ""
        } else {
            procedureUnSafeTV.text = ""
            procedureSafeTV.text = conversation.behaviourCodes.procedure
        }
    }
}