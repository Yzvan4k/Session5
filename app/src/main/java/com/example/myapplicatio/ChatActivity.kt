package com.example.myapplicatio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicatio.models.ModelDataChat
import com.example.myapplicatio.models.ModelItemChat
import com.example.myapplicatio.models.ModelMessage
import com.example.myapplicatio.models.ModelUser

class ChatActivity : AppCompatActivity(), Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        Connection.callbacks.add(this)
    }

    override fun onOpen() {

    }

    override fun onMessage(modelMessage: ModelMessage) {

    }

    override fun onChats(chats: List<ModelItemChat>) {

    }

    override fun onChat(chat: ModelDataChat) {

    }

    override fun onPerson(modelUser: ModelUser) {

    }

    override fun onDestroy(){
        super.onDestroy()
        Connection.callbacks.remove(this)
            }
}