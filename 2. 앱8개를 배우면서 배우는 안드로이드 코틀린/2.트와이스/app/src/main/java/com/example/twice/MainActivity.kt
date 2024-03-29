package com.example.twice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    // 1. 스플래쉬 설정
    // /manifests/AndroidManifest.xml 에서 <intent-filter> 위치 변경

    // 2. 타이틀바 제거
    // /res/values/themes/themes.xml 에서 코드 추가
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<ImageView>(R.id.member1)
        val btn2 = findViewById<ImageView>(R.id.member2)
        val btn3 = findViewById<ImageView>(R.id.member3)

        btn1.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            // intent에 데이터 추가
            intent.putExtra("data", "1")
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "2")
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "3")
            startActivity(intent)
        }

    }

}