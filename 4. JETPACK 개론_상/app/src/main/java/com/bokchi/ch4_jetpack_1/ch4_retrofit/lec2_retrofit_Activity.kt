package com.bokchi.ch4_jetpack_1.ch4_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bokchi.ch4_jetpack_1.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// json 데이터 받아올 수 있는 사이트
// https://jsonplaceholder.typicode.com/
// https://jsonplaceholder.typicode.com/posts
// https://jsonplaceholder.typicode.com/posts/3
class lec2_retrofit_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec1_retrofit)

        val api = lec2_RetrofitInstance.getInstance().create(lec2_MyApi::class.java)
        api.getPost1().enqueue(object : Callback<lec2_Post> {
            override fun onResponse(call: Call<lec2_Post>, response: Response<lec2_Post>) {
                Log.d("API1", response.body().toString())
            }

            override fun onFailure(call: Call<lec2_Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })

        api.getPostNumber(2).enqueue(object : Callback<lec2_Post> {
            override fun onResponse(call: Call<lec2_Post>, response: Response<lec2_Post>) {
                Log.d("API2", response.body().toString())
            }

            override fun onFailure(call: Call<lec2_Post>, t: Throwable) {
                Log.d("API2", "fail")
            }

        })

    }
}