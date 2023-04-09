package com.example.myapplicatio.models

data class ModelMessage(
    val message:String,
    val id:Int,
    val isYou:Boolean,
    val datetime:String,
    val idUser:String,
    val isAudio:Boolean
)
data class ModelItemMessage(
    val id:Int,
    val idChat:Int,
    val text :String,
    val datetime:String,
    val idUser: String,
    val isAudio: Boolean
)
