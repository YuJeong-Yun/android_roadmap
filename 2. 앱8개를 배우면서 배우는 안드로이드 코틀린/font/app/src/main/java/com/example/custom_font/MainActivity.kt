package com.example.custom_font

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // res 아래에 font directory 생성해서 폰트 파일 추가
        // xml 파일의 폰트 적용할 부분에 태그 추가
    }
}