package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class lec5_ViewModelFactory(private val num: Int) : ViewModelProvider.Factory {
    // android.lifecycle 2.4.0 버전부터
    // ViewModelProvider.Factory.create method no longer allows nullable generic.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(lec5_ViewModel::class.java)) {
            return lec5_ViewModel(num) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}
