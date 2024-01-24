package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R

class lec2_MainActivity : AppCompatActivity() {

    lateinit var viewModel: lec2_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec2_main)

        viewModel = ViewModelProvider(this).get(lec2_ViewModel::class.java)

        val plusBtn: Button = findViewById(R.id.plus)
        val minusBtn: Button = findViewById(R.id.minus)

        val resultArea: TextView = findViewById(R.id.result)

        resultArea.text = viewModel.countValue.toString()

        plusBtn.setOnClickListener {
            viewModel.plus()
            resultArea.text = viewModel.countValue.toString()
        }

        minusBtn.setOnClickListener {
            viewModel.minus()
            resultArea.text = viewModel.countValue.toString()
        }


    }
}