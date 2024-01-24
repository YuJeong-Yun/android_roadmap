package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class lec5_ViewModel(num : Int) : ViewModel() {

    init {
        Log.d("MainViewModel", num.toString())
    }
}