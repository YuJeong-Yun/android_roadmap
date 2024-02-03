package com.bokchi.ch4_jetpack_1.ch7_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.bokchi.ch4_jetpack_1.R

class lec5_Navigation_BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_lec5__navigation__blank1, container, false)

        // nav.xml 에서 데이터 받을 fragment 클릭 -> attribute -> arguments 에 key 값, 타입, default 값 넣고 추가
        val action = lec5_Navigation_BlankFragment1Directions.actionLec5NavigationBlankFragment1ToLec5NavigationBlankFragment2("abcdef")
        // 값 안넣어도 null 값 안뜨고 설정한 default값 뜸
        val actionNoValue =
            lec5_Navigation_BlankFragment1Directions.actionLec5NavigationBlankFragment1ToLec5NavigationBlankFragment2()

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            Navigation.findNavController(view).navigate(actionNoValue)
        }

        return view
    }

}