package com.example.bts_lecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // 색상 안먹히면 아래 파일 수정
    // /res/values/themes/themes.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. (프로그램이) 화면 클릭 인식
        val image1 = findViewById<ImageView>(R.id.btsImage1)
        image1.setOnClickListener {
            Toast.makeText(this, "1번 클릭 완료", Toast.LENGTH_LONG).show()

            // 2. 화면이 클릭되면 다음 화면으로 넘어가서, 사진을 크게 보여줌
            // 새로운 인텐트(작업의 의도를 나타내는 객체)를 생성. Intent 클래스는 액티비티 간에 통신이나 작업을 전달하는 데 사용
            val intent = Intent(this, Bts1Activity::class.java)
            // 생성한 인텐트를 사용하여 다른 액티비티를 시작
            startActivity(intent)
        }

        // 7개 image들의 이름을 다 붙이고, 각각 클릭시, 다른 액티비티로 이동
        val image2 = findViewById<ImageView>(R.id.btsImage2)
        image2.setOnClickListener {
            val intent = Intent(this, Bts2Activity::class.java)
            startActivity(intent)
        }
        val image3 = findViewById<ImageView>(R.id.btsImage3)
        image3.setOnClickListener {
            val intent = Intent(this, Bts3Activity::class.java)
            startActivity(intent)
        }
        // ...
    }
}