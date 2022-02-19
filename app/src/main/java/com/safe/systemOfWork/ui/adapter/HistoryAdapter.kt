package com.safe.systemOfWork.ui.adapter

import android.content.Context
import android.os.Build
import android.view.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.safe.systemOfWork.R
import com.safe.systemOfWork.helper.interfaces.ItemClickWithObjectListener
import com.safe.systemOfWork.model.Conversation
import kotlinx.android.synthetic.main.item_conversation_layout.view.*
import java.util.ArrayList

class HistoryAdapter(private val context: Context, var data: ArrayList<Conversation>, val  listener: ItemClickWithObjectListener) : RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conversation_layout, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.onBind(item, context, listener)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view = v

        fun onBind(item: Conversation,context: Context, listener: ItemClickWithObjectListener) {

            if (item.behaviourObserved == "Safe") {
                view.behaviourTV.setTextColor(ContextCompat.getColor(context, R.color.green))
            } else {
                view.behaviourTV.setTextColor(ContextCompat.getColor(context, R.color.red))
            }

            view.personNameTV.text = item.personObservedName
            view.dateTV.text = item.date
            view.timeTV.text = item.time
            view.behaviourTV.text = item.behaviourObserved

            view.card_view.setOnClickListener {
                listener.onItemClickObject(item)
            }


        }
    }
}