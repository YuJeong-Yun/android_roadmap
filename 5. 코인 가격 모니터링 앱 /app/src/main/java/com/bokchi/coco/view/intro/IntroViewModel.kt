package com.bokchi.coco.view.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bokchi.coco.dataStore.MyDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class IntroViewModel : ViewModel() {

    private val _first = MutableLiveData<Boolean>()
    val first : LiveData<Boolean>
        get() = _first

    fun checkFirstFlag() = viewModelScope.launch {
        delay(2000) // 로티 애니메이션 오래 보여주기 위해 준 딜레이

        val getData = MyDataStore().getFirstData()

        _first.value = getData

        Timber.d(getData.toString())

    }
}