package com.bokchi.ch4_jetpack_1.ch4_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object lec2_RetrofitInstance {

        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val client = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getInstance() : Retrofit {
            return client
        }

    }