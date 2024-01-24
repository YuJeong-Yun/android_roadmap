package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import androidx.lifecycle.ViewModel

class lec3_TestFragmentViewModel : ViewModel() {

    var countValue = 0

    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount(): Int {
        return countValue
    }

}