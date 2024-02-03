package com.bokchi.ch4_jetpack_1.ch7_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.ch4_jetpack_1.R

// 1 -> 2 -> 3 -> 4 -> 5 backbutton 누르면 원래는 -> 5 4 3 2 1
// 5 -> 1 로 이도록 하는 방법
class lec3_Navigtaion_Back_Button_Event_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec3_navigtaion_back_button_event)
    }
}