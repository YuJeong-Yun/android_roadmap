package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R

/**
 * LifeData와 ViewModel 같이  써보기
 */
class lec2_LiveData_ViewModel_Activity : AppCompatActivity() {
    private lateinit var viewModel: lec2_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec2_live_data_view_model)

        viewModel = ViewModelProvider(this).get(lec2_ViewModel::class.java)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testMutableLiveData.observe(this, Observer {
            findViewById<TextView>(R.id.textArea).text =
                viewModel.testMutableLiveData.value.toString()
        })

    }
}