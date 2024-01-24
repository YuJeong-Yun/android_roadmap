package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.bokchi.ch4_jetpack_1.R

class lec3_MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec3_main)

//        if(savedInstanceState == null) {

        val transaction = manager.beginTransaction()
        val fragment = lec3_TestFragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

//        }


    }
}