package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec4FragmentLiveDataLifeCycleOwner1Binding

// Fragment LiveData / viewLifecyclerOwner

// https://developer.android.google.cn/codelabs/kotlin-android-training-live-data/index.html?index=..%2F..android-kotlin-fundamentals&hl=IT#4
// https://developer.android.com/topic/libraries/view-binding
class lec4_Fragment_LiveData_LifeCycleOwner1_Activity : AppCompatActivity() {

        private lateinit var binding : ActivityLec4FragmentLiveDataLifeCycleOwner1Binding

        val manager = supportFragmentManager

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            binding = ActivityLec4FragmentLiveDataLifeCycleOwner1Binding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            binding.btn1.setOnClickListener {
                val transaction1 = manager.beginTransaction()
                val fragment1 = lec4_BlankFragment1()
                transaction1.replace(R.id.frameArea, fragment1)
                transaction1.addToBackStack(null)
                transaction1.commit()
            }

            binding.btn2.setOnClickListener {
                val transaction2 = manager.beginTransaction()
                val fragment2 = lec4_BlankFragment2()
                transaction2.replace(R.id.frameArea, fragment2)
                transaction2.addToBackStack(null)
                transaction2.commit()
            }



        }
    }