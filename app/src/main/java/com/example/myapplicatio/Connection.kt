package com.example.myapplicatio

import com.example.myapplicatio.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

object Connection {
    const val url = "ws://strukov-artemii.online:8085"

    var callbacks:MutableList<Callback> = mutableListOf()

    val client = object:WebSocketClient(URI("${url}/chat"), mapOf("idUser" to "6")){
        override fun onOpen(handshakedata: ServerHandshake?) {
            callbacks.forEach{
                it.onOpen()
            }
        }

        override fun onMessage(message: String) {
            if ("\"type\":\"person\"" in message) {
                val modelUser = Gson().fromJson<ModelChatAnswer<ModelUser>>(message, object : TypeToken<ModelChatAnswer<ModelUser>>() {}.type).body
                callbacks.forEach {
                    it.onPerson(modelUser)
                }
            } else if ("\"type\":\"chats\"" in message) {
                val chats = Gson().fromJson<ModelChatAnswer<List<ModelItemChat>>>(message, object : TypeToken<ModelChatAnswer<ModelItemChat>>() {}.type).body
                callbacks.forEach {
                    it.onChats(chats)
                }
            } else if ("\"type\":\"chat\"" in message) {
                val modelChat = Gson().fromJson<ModelChatAnswer<ModelDataChat>>(message, object : TypeToken<ModelChatAnswer<ModelDataChat>>() {}.type).body
                callbacks.forEach {
                    it.onChat(modelChat)
                }
            } else if ("\"type\":\"message\"" in message) {
                val modelMessage = Gson().fromJson<ModelChatAnswer<ModelMessage>>(message, object : TypeToken<ModelChatAnswer<ModelMessage>>() {}.type).body
                callbacks.forEach {
                    it.onMessage(modelMessage)
                }
            }
        }

        override fun onClose(code: Int, reason: String?, remote: Boolean) {}

        override fun onError(ex: Exception?) {}

    }
}
interface Callback {
    fun onOpen()

    fun onMessage(modelMessage: ModelMessage)

    fun onChats(chats:List<ModelItemChat>)

    fun onChat(chat:ModelDataChat)

    fun onPerson(modelUser: ModelUser)
}