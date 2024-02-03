package com.bokchi.ch4_jetpack_1.ch7_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bokchi.ch4_jetpack_1.R

class lec5_Navigation_BlankFragment2 : Fragment() {

    val args: lec5_Navigation_BlankFragment2Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_lec5__navigation__blank2, container, false)

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_lec5_Navigation_BlankFragment2_to_lec5_Navigation_BlankFragment1)
        }

        Log.d("BlankFragment2", args.key)

        return view
    }

}