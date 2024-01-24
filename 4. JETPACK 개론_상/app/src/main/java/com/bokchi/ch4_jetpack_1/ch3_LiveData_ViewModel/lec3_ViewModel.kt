package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// https://developer.android.com/codelabs/kotlin-android-training-live-data?index=..%2F..android-kotlin-fundamentals&hl=fi_FI#5

class lec3_ViewModel : ViewModel() {

    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData: LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue() {
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }
}