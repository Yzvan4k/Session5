package com.example.myapplicatio.models

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface API {
    @GET("chat")
    fun getchat(@Query("idChat") idChat:Int, @Header("Authorization") bearerToken:String):Call<ModelChat>
}