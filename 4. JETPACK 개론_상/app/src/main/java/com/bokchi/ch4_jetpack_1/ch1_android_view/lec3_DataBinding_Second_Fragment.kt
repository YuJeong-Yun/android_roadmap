package com.bokchi.ch4_jetpack_1.ch1_android_view

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.FragmentLec3DataBindingSecondBinding

/**
 * Fragment에서 DataBinding 사용법
 */
class lec3_DataBinding_Second_Fragment : Fragment() {

    private lateinit var binding: FragmentLec3DataBindingSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_lec3__data_binding__second_, container, false
        )
        binding.fragmentText.text = "변경된 fragment Text"

        return binding.root
    }

}