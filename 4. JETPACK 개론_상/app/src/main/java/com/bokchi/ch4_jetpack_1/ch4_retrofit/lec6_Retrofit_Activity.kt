package com.bokchi.ch4_jetpack_1.ch4_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R

class lec6_Retrofit_Activity : AppCompatActivity() {

    lateinit var viewModel: lec6_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec6_retrofit)

        viewModel = ViewModelProvider(this).get(lec6_ViewModel::class.java)
        viewModel.getPost1()
        viewModel.getPostNumber(3)

        val area1 = findViewById<TextView>(R.id.area1)
        val area2 = findViewById<TextView>(R.id.area2)

        viewModel.liveWord1.observe(this, Observer {
            area1.text = it.toString()
        })

        viewModel.liveWord2.observe(this, Observer {
            area2.text = it.toString()
        })

    }
}