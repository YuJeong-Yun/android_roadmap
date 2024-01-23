package com.bokchi.ch4_jetpack_1.ch1_android_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec4AdapterViewBindingBinding

/**
 * 리사이클러뷰에서 뷰바인딩 사용
 */
class lec4_Adapter_ViewBinding : AppCompatActivity() {

    private lateinit var binding: ActivityLec4AdapterViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLec4AdapterViewBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val array = ArrayList<String>()

        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")

        val customViewAdapter = lec4_CustomAdapter(array)

        val rv = binding.rv
        rv.adapter = customViewAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}