package com.bokchi.ch4_jetpack_1.ch7_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.ch4_jetpack_1.R

class lec6_Animation_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec6_animation)

        // nav.xml 에서 선 클릭 -> attribute -> Animations
        /**
         * enterAnim -> A -> B 갈 때 B가 보이는 방식
         * exitAnim -> A -> B 갈 때 A가 사라지는 방식
         * popEnterAnim -> 뒤로가기 B -> A로 올 때 A가 나타나는 방식
         * popExitAnim -> 뒤로가기로 B -> A로 올 때 B가 사라지는 방식
         */
    }
}