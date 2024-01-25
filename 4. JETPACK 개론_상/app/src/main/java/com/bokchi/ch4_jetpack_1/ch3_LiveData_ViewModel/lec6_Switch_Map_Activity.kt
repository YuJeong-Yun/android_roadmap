package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec6SwitchMapBinding

/**
 * 라이브 데이터 변경
 * LiveData Transformations
 */
class lec6_Switch_Map_Activity : AppCompatActivity() {


    private lateinit var binding: ActivityLec6SwitchMapBinding
    private lateinit var viewModel: lec6_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lec6_switch_map)
        viewModel = ViewModelProvider(this).get(lec6_ViewModel::class.java)

        viewModel.liveCount.observe(this, Observer {
            // binding.resultArea1.text = (it + it).toString()
            // binding.resultArea2.text = (it * it).toString()
        })

        viewModel.mapLiveData.observe(this, Observer {
            binding.resultArea1.text = it.toString()
        })

        viewModel.switchMapLiveData.observe(this, Observer {
            binding.resultArea2.text = it.toString()
        })

        binding.btnArea.setOnClickListener {
            val count = binding.inputArea.text.toString().toInt()
            viewModel.setLiveDataValue(count)
        }


    }
}