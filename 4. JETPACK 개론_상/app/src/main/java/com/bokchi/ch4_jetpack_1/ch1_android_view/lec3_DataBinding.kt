package com.bokchi.ch4_jetpack_1.ch1_android_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec3DataBindingBinding
import kotlin.math.log

/**
 * DataBinding 사용 방법
 */
// 1. app build.gradle 에 아래 추가
/*
buildFeatures {
    dataBinding = true
}
 */

// 2. 레이아웃 파일 <layout> 태그로 감싸주기
class lec3_DataBinding : AppCompatActivity() {

    private lateinit var binding: ActivityLec3DataBindingBinding
    var testCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_lec3_data_binding)

        binding.dataBindingEx.text = "바뀐 텍스트"

        // 프래그먼트 테스트위한 코드
        binding.dataBindingEx.setOnClickListener {
            val intent = Intent(this, lec3_DataBinding_Second::class.java)
            startActivity(intent)
        }

        // databinding 데이터 결합
        val person = Person("홍길동", 20)
        binding.user = person


    }

    fun myClick(view: View) {
        Log.e("myclick", "click")
        testCount++

        val person = Person("홍길동", testCount)
        binding.user = person
    }
}