package com.bokchi.ch4_jetpack_1.ch4_retrofit

class lec9_Repository {

    private val client = lec8_RetrofitInstance.getInstance().create(lec8_MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}