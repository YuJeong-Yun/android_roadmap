package com.bokchi.ch4_jetpack_1.ch4_retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class lec9_ViewModel : ViewModel() {

    private val repository = lec9_Repository()

    private val _result = MutableLiveData<List<lec8_Plant>>()
    val result: LiveData<List<lec8_Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", repository.getAllData().toString())
        _result.value = repository.getAllData()
    }

}