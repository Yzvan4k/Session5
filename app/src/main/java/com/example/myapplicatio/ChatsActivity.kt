package com.example.myapplicatio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.myapplicatio.models.ModelDataChat
import com.example.myapplicatio.models.ModelItemChat
import com.example.myapplicatio.models.ModelMessage
import com.example.myapplicatio.models.ModelUser

class ChatsActivity : AppCompatActivity(),Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)

        Connection.callbacks.add(this)
        Connection.client.connect()


    }

    override fun onOpen() {
        Connection.client.send("/chats")
    }

    override fun onMessage(modelMessage: ModelMessage) {

    }

    override fun onChats(chats: List<ModelItemChat>) {
        runOnUiThread { Toast.makeText(this, "${chats.joinToString { it.toString() }} ", Toast.LENGTH_LONG).show() }
    }

    override fun onChat(chat: ModelDataChat) {

    }

    override fun onPerson(modelUser: ModelUser) {
        runOnUiThread { Toast.makeText(this, "Привет ${modelUser.firstname}", Toast.LENGTH_LONG).show() }
    }
}