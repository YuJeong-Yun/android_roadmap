package com.bokchi.ch4_jetpack_1.ch4_retrofit

import retrofit2.http.GET

interface lec8_MyApi {
    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants(): List<lec8_Plant>
}