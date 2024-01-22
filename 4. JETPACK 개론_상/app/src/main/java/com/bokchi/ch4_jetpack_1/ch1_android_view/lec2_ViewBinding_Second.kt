package com.bokchi.ch4_jetpack_1.ch1_android_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.ch4_jetpack_1.R

class lec2_ViewBinding_Second : AppCompatActivity() {

    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec2_view_binding_second)

        // 프래그먼트 출력 코드
        val transaction = manager.beginTransaction()
        val fragment = lec2_ViewBinding_Second_Fragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}