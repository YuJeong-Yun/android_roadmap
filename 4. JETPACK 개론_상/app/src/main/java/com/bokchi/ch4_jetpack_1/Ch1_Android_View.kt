package com.bokchi.ch4_jetpack_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Ch1_Android_View : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ch1_android_view)

        //////////////////// 1. Kotlin Extensions ////////////////////
        // app build.gradle 에 [   id("kotlin-android-extensions") ] 추가
        // 아래와 같이 바로 id명으로 가져올 수 있음
        // but null값 체크 못 함. 권장 XXXXX
        // btn1.text = "abcd"
        // btn2.text = "abcd"

    }
}