package com.bokchi.ch4_jetpack_1.ch1_android_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec5AdapterDataBindingBinding

class lec5_Adapter_DataBinding : AppCompatActivity() {

    private lateinit var binding: ActivityLec5AdapterDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lec5_adapter_data_binding)

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

        val customDataAdapter = lec5_CustomAdapter(array)

        val rv = binding.rv
        rv.adapter = customDataAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}