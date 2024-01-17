package com.example.rv_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()
        items.add("a")
        items.add("b")
        items.add("c")

        val rv = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter // 리싸이클러뷰 어댑터에 우리가 만든 어댑터를 설정하는 부분
        rv.layoutManager =
            LinearLayoutManager(this) // 리싸이클러뷰가 어떻게 표시될지 layoutManger를 설정. 여기서는 LinearLayoutManager로 설정

        ////////// 클릭 이벤트
        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_LONG).show()
            }
        }
        //////////////////////

    }
}