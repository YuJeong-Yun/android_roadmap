package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class lec2_ViewModel : ViewModel() {

    var testMutableLiveData = MutableLiveData(0)

    // MutableLiveData <-> LiveData 사용법 다름!! 추후에 배움

    fun plusLiveDataValue() {
        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    }

}