package com.example.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databinding_ex.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    // binding 변수 선언. 초기화는 나중에
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1번 방식 - findViewById
        val btn = findViewById<Button>(R.id.testBtnId)
        btn.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
        }

        // 2번 방식 - 데이터 바인딩 이용하는 방식
        // 2-1) Gradle / build.gradle (Module)에 아래 코드 추가
        //     dataBinding {
        //        enable = true
        //    }
        // 2-2) activity_main.xml 코드 전에 layout 태그로 감싸줌

        // binding 변수 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.testBtnId.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
        }


        //////////////////////////////////////////////////
        // log 남기는 법
        var test = "123"
        Log.d("MainActivity", test);

        // 로그 종류
        Log.e("MainActivity", "1"); // 오류
        Log.w("MainActivity", "1"); // 경고
        Log.i("MainActivity", "1"); // 정보
        Log.d("MainActivity", "1"); // 디버그
        Log.e("MainActivity", "1"); // 상세
    }
}