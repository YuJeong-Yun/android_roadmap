package com.bokchi.ch4_jetpack_1.ch4_retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class lec6_ViewModel : ViewModel() {

    private val retrofitInstance =
        lec2_RetrofitInstance.getInstance().create(lec6_MyApi::class.java)

    private var _mutableWord1 = MutableLiveData<String>()
    val liveWord1: LiveData<String>
        get() = _mutableWord1

    private var _mutableWord2 = MutableLiveData<String>()
    val liveWord2: LiveData<String>
        get() = _mutableWord2

    fun getPost1() = viewModelScope.launch {
        val post = retrofitInstance.getPost1()
        Log.d("MainViewModel", post.toString())
        _mutableWord1.value = post.title
      }

    fun getPostNumber(number: Int) = viewModelScope.launch {
        val post = retrofitInstance.getPostNumber(number)
        Log.d("MainViewModel", post.toString())
        _mutableWord2.value = post.title
    }


}