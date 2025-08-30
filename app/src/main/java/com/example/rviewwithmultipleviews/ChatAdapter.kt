package com.example.rviewwithmultipleviews

import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(val messages:List<ChatMessage>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //created static like constants
    private companion object{
        const val TYPE_SENT=1
        const val TYPE_RECEIVED=2           //constants will be used by getItemViewType() to identify which layout to inflate.
    }

    //called by recyclerview each time to know which view type that position uses
    override fun getItemViewType(position: Int): Int {
        return if(messages[position].isSent) TYPE_SENT else TYPE_RECEIVED   //checks the isSent flag on the message to return the correct type
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        return if(viewType== TYPE_SENT){
            val v= inflater.inflate(R.layout.row_msg_sent,parent,false)
            SentVH(v)       //create the appropriate ViewHolder
        }
        else{
            val v=inflater.inflate(R.layout.row_msg_received,parent,false)
            ReceivedVH(v)  //create the appropriate ViewHolder
        }
    }

    override fun getItemCount() =messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg=messages[position]
       when(holder){     //because we have 2 view types here
           is SentVH -> holder.bind(msg)
           is ReceivedVH ->holder.bind(msg)   //fun bind sets the Textview to the message content
       }
    }

    class SentVH(itemView: View) :RecyclerView.ViewHolder(itemView){  //view holder for sent messages
        private val sentView:TextView =itemView.findViewById(R.id.tv_msg)
        fun bind(item: ChatMessage) {
            sentView.text = item.message
        }
    }

    class ReceivedVH(itemView: View) :RecyclerView.ViewHolder(itemView){    //view holder for receive messages
        var receivedView:TextView =itemView.findViewById(R.id.tv_msg)
        fun bind(item: ChatMessage){
            receivedView.text=item.message
        }
    }
}