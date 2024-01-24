package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.FragmentLec3TestBinding

// https://developer.android.com/guide/fragments/lifecycle
class lec3_TestFragment : Fragment() {

    private lateinit var binding: FragmentLec3TestBinding
    private lateinit var viewmodel: lec3_TestFragmentViewModel
    var countValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TestFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lec3__test, container, false)

        viewmodel = ViewModelProvider(this).get(lec3_TestFragmentViewModel::class.java)

        binding.resultArea.text = viewmodel.getCount().toString()

        binding.plus.setOnClickListener {
            viewmodel.plus()
            binding.resultArea.text = viewmodel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewmodel.minus()
            binding.resultArea.text = viewmodel.getCount().toString()
        }

        return binding.root
    }

}