package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec4ShareViewModelFragmentBinding
import lec4_Fragment

// ViewModel -> Activity/Fragment 공유
// => Activity 의 값을 Fragment 쓰고 싶거나 or Fragment 에서 값을 ViewModel 의 값으로 사용하기 위해서

// app에 build.gradle 추가
// implementation("androidx.fragment:fragment-ktx:1.4.1")
class lec4_share_ViewModel_Activity_Fragment : AppCompatActivity() {

    lateinit var binding: ActivityLec4ShareViewModelFragmentBinding
    lateinit var viewModel: lec4_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_lec4_share_view_model_fragment)
        viewModel = ViewModelProvider(this).get(lec4_ViewModel::class.java)

        binding.resultArea.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        // showFragment 클릭 시 프래그먼트가 나오게
        val manager = supportFragmentManager

        binding.showFragment.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = lec4_Fragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}