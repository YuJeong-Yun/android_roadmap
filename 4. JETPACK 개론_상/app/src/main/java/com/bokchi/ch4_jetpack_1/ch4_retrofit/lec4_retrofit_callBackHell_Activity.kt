package com.bokchi.ch4_jetpack_1.ch4_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bokchi.ch4_jetpack_1.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 비동기적으로 실행되므로 실행 순서를 보장하기 위해서는 아래와 같이 작성해야함
 * => 복잡하고 가독성이 떨어지는 코드
 */
class lec4_retrofit_callBackHell_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec4_retrofit_call_back_hell)

        val api = lec2_RetrofitInstance.getInstance().create(lec2_MyApi::class.java)

        // 1. 유저 정보를 가져와서 (userId)
        api.getPost1().enqueue(object : Callback<lec2_Post> {
            override fun onResponse(call: Call<lec2_Post>, response: Response<lec2_Post>) {
                Log.d("API1", response.body().toString())
                // 2. userId 기반으로 데이터를 가져오고 가져온 닉네임값
                api.getPostNumber(2).enqueue(object : Callback<lec2_Post> {
                    override fun onResponse(call: Call<lec2_Post>, response: Response<lec2_Post>) {
                        Log.d("API2", response.body().toString())
                        // 3. 닉네임 기반으로 데이터를 가져오고 유저의 댓글을 가져와서
                        api.getPostNumber(3).enqueue(object : Callback<lec2_Post> {
                            override fun onResponse(
                                call: Call<lec2_Post>, response: Response<lec2_Post>
                            ) {
                                Log.d("API3", response.body().toString())
                                // 4. 유저의 댓글 기반으로, 대댓글
                                api.getPostNumber(4).enqueue(object : Callback<lec2_Post> {
                                    override fun onResponse(
                                        call: Call<lec2_Post>, response: Response<lec2_Post>
                                    ) {
                                        Log.d("API4", response.body().toString())
                                    }

                                    override fun onFailure(call: Call<lec2_Post>, t: Throwable) {
                                        Log.d("API4", "fail")
                                    }

                                })
                            }

                            override fun onFailure(call: Call<lec2_Post>, t: Throwable) {
                                Log.d("API3", "fail")
                            }

                        })
                    }

                    override fun onFailure(call: Call<lec2_Post>, t: Throwable) {
                        Log.d("API2", "fail")
                    }

                })
            }

            override fun onFailure(call: Call<lec2_Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })


    }
}