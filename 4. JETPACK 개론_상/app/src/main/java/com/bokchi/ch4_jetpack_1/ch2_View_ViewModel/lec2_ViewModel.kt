package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel

// ViewModel - 안드로이드의 생명 주기를 관리하기 쉽다 = 상태(Life Cycle)가 변경될 때 마다 데이터를 관리해줘야 하는데 관리가 편하다
// UI 컨트롤러에서 모든 것을 다 하려고 하면 다 하려 하면 복잡해진다 -> ViewModel을 사용하면 테스트나 관리가 용이
class lec2_ViewModel : ViewModel() {
    var countValue = 0

    // 뷰모델 생성 확인 위한 코드
    init {
        Log.d("MainViewModel", "init")
    }

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