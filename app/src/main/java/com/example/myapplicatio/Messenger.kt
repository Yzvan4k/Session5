package com.example.myapplicatio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicatio.databinding.ActivityMessengerBinding
import com.example.myapplicatio.models.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class Messenger : AppCompatActivity(),Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val messenger = ActivityMessengerBinding.inflate(layoutInflater)
        setContentView(messenger.root)

        Connection.callbacks.add(this)


        messenger.recChats.adapter =ChatListAdapter()
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
}