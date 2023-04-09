package com.example.session5test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.session5test.databinding.ActivityMessengerBinding
import org.java_websocket.client.WebSocketClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("http://95.31.130.149:8085/")
    .build()
val api = retrofit.create(API::class.java)

var token = ""

val webSocketClient:WebSocketClient()

class Messenger : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val messenger = ActivityMessengerBinding.inflate(layoutInflater)
        setContentView(messenger.root)

        val list = listOf<chatData>(chatData("T","Тех. поддержка"),
        chatData("K","Евгений Касперский"),
        chatData("C","Артемий Скляров")
        )

        messenger.recChats.adapter = ChatsAdapter(list)
        messenger.recChats.layoutManager = LinearLayoutManager(this,)





    }
}