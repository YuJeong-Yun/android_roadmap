package com.bokchi.ch4_jetpack_1.ch7_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.bokchi.ch4_jetpack_1.R


class lec3_BlankFragment4 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_lec3__blank4, container, false)

        view.findViewById<Button>(R.id.btn4).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_lec3_BlankFragment4_to_lec3_BlankFragment5)
        }

        return view
    }
}