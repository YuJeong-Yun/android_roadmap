package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class lec4_BlankViewModel1 : ViewModel() {

    private var _mutableCount = MutableLiveData(0)
    val liveCount: LiveData<Int>
        get() = _mutableCount


    fun plusCountValue() {
        _mutableCount.value = _mutableCount.value?.plus(1)
    }

}