package com.bokchi.ch4_jetpack_1.ch7_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.bokchi.ch4_jetpack_1.R

class lec4_Navigation_BlankFragment2 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_lec4__navigation__blank2, container, false)

        // 데이터 받기
        val getString = arguments?.getString("key")
        Log.d("BlankFragment2", getString.toString())

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_lec4_Navigation_BlankFragment2_to_lec4_Navigation_BlankFragment1)
        }

        return view
    }

}