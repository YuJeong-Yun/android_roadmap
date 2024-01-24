package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R

/**
 * MutableLiveData - 외부(액티비티 등)에서 변경 가능
 * LiveData - 외부에서 읽을 순 있지만 변경 불가 (캡슐화)
 */
class lec3_LiveData_MutableLiveData_Activity : AppCompatActivity() {

    private lateinit var viewModel: lec3_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec3_live_data_mutable_live_data)

        viewModel = ViewModelProvider(this).get(lec3_ViewModel::class.java)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testLiveData.observe(this, Observer {
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })
    }
}