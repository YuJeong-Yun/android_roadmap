package com.bokchi.ch4_jetpack_1.ch1_android_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec2ViewBindingBinding

/**
 * Acitivity에서 ViewBinding 사용방법
 */
class lec2_ViewBinding : AppCompatActivity() {

    private lateinit var binding: ActivityLec2ViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // app build.gradle에 추가
        /*
        buildFeatures {
            viewBinding = true
        }
        */

        super.onCreate(savedInstanceState)

        binding = ActivityLec2ViewBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.testText.text = "변경된 텍스트"

        // 프래그먼트에서 확인하기 위한 코드
        binding.testText.setOnClickListener {
            val intent = Intent(this, lec2_ViewBinding_Second::class.java)
            startActivity(intent)
        }


    }
}