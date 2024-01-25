package com.bokchi.ch4_jetpack_1.ch4_retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface lec6_MyApi {

    @GET("posts/1")
    suspend fun getPost1(): lec2_Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number: Int
    ): lec2_Post

}