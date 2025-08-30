package com.example.rviewwithmultipleviews

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rv_chat)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val data = listOf(
            ChatMessage("Hey!", true),
            ChatMessage("Hello 😊", false),
            ChatMessage("How’s your prep going?", false),
            ChatMessage("Grinding RecyclerView today 💪", true),
            ChatMessage("Nice! Next, multi-view types?", false),
            ChatMessage("Already on it 😎", true)
        )

        val rv:RecyclerView=findViewById(R.id.rv_chat)
        val lm =LinearLayoutManager(this).apply{
            stackFromEnd=true       //start list at the bottom like chats
        }
        rv.layoutManager=lm

        rv.adapter=ChatAdapter(data)   //create the adapter with the message list and set it on the recyclerview
    }
}