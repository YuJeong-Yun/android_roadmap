package com.bokchi.ch4_jetpack_1.ch4_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface lec2_MyApi {
    @GET("posts/1")
    fun getPost1(): Call<lec2_Post>

    @GET("posts/{number}")
    fun getPostNumber(@Path("number") number: Int): Call<lec2_Post>
}