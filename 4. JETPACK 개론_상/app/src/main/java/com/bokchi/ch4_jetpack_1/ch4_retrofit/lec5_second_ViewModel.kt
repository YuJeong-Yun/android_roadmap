package com.bokchi.ch4_jetpack_1.ch4_retrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// https://developer.android.com/topic/libraries/architecture/coroutines?hl=ko
class lec5_second_ViewModel : ViewModel() {

    /**
     * 코루틴 안에서 실행 중일 때 뒤로가기 눌러도 계속 실행 됨.
     * 뷰 모델이 없어질 때 코루틴도 중지되는 작업 필요 !!
     * => viewModelScope 이용
     */
    fun a() {
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 0..10) {
                delay(1000)
                Log.d("SecondViewModel A : ", i.toString())
            }
        }
    }

    fun b() {
        viewModelScope.launch {
            for (i in 0..10) {
                delay(1000)
                Log.d("SecondViewModel B : ", i.toString())
            }
        }
    }


}