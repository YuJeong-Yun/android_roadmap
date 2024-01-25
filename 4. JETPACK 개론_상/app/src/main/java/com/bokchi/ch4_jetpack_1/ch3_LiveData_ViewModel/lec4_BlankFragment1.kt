package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.databinding.FragmentLec4Blank1Binding

class lec4_BlankFragment1 : Fragment() {

    // ViewBinding + LiveData

    private val TAG = "BlankFragment1"

    private var _binding: FragmentLec4Blank1Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: lec4_BlankViewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLec4Blank1Binding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(lec4_BlankViewModel1::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            viewModel.plusCountValue()
        }

        // fragment와 view의 lifecycle이 다르므로 여기서는 this 대신 viewLifecycleOwner 사용
        viewModel.liveCount.observe(viewLifecycleOwner, Observer {
            binding.text1.text = it.toString()
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }


}