package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    // ListView는 Linearlayer와 주로 사용

    // MainActivity에서 Adapter로 리스트 데이터 보내주고 ->
    // Adapter에서 listview_item.xml 파일로 activity_main.xml(listview)에 하나씩 넣어줌

    // ListViewAdapter.kt 파일 생성
    // 여기서 리스트 데이터 받아야함

    // res/layout/listview_item (Layout Resource View) 생성

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. MainActivity에서 Adapter로 데이터 전달
        /** 데이터를 "a","b","c" 등 단순한 문자열로 전달할 때
        val list_item = mutableListOf<String>()
        list_item.add("A")
        list_item.add("B")
        list_item.add("C")
         */

        /** 데이터를 ListViewModel("a","b")등 객체로 전달할 때 */
        val list_item = mutableListOf<ListViewModel>()
        list_item.add(ListViewModel("a", "b"))
        list_item.add(ListViewModel("c", "d"))
        list_item.add(ListViewModel("e", "f"))

        // 2. Adapter에서 activity_main으로 listview_item 데이터 전달
        val listview = findViewById<ListView>(R.id.mainListView)

        val listAdapter = ListViewAdapter(list_item)
        // listview_item과 activity_main 연결
        listview.adapter = listAdapter
    }
}