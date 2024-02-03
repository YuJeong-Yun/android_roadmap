package com.bokchi.ch4_jetpack_1.ch7_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.bokchi.ch4_jetpack_1.R

class lec4_Navigation_BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        // 데이터 보내기
        // 해당하는 key 값 없으면 받을 때 null 값 뜸
        // => 공식문서에서 Safe Args 권장
        val bundle = Bundle()
        bundle.putString("key", "value")

        val view = inflater.inflate(R.layout.fragment_lec4__navigation__blank1, container, false)

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_lec4_Navigation_BlankFragment1_to_lec4_Navigation_BlankFragment2,
                bundle
            )
        }

        return view
    }

}