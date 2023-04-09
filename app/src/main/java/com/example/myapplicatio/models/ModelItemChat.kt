package com.example.myapplicatio.models

data class ModelItemChat(
    val id:Int,
    val first:ModelUser,
    val second:ModelUser
)
data class ModelUser (
    val id:Int,
    val firstname:String,
    val lastname:String,
    val patronymic:String,
    val avatar:String
)