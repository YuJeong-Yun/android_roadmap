package com.bokchi.ch4_jetpack_1.ch1_android_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.FragmentLec2ViewBindingSecondBinding


/**
 * Fragment에서 ViewBinding 사용 방법
 */
class lec2_ViewBinding_Second_Fragment : Fragment() {

    private var _binding: FragmentLec2ViewBindingSecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLec2ViewBindingSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.fragmentText.text = "이거는 fragment Text"

        return view
    }

}