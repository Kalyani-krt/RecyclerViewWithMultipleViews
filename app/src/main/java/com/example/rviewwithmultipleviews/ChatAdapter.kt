package com.example.rviewwithmultipleviews

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(val messages:List<ChatMessage>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //created static like constants
    private companion object{
        const val TYPE_SENT=1
        const val TYPE_RECEIVED=2
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}