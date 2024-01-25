package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

class Lec7ViewModel : ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord: LiveData<String>
        get() = _mutableWord

    private var _randomMutableWord = MutableLiveData("")
    val randomLiveWord: LiveData<String>
        get() = _randomMutableWord

    val newData = liveWord.switchMap() {
        getRandomWordShuffled(it)
    }

    // 시작할 때 layout에 바로 출력되도록
    init {
        getNextData()
    }

    fun getNextData() {

        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)

    }

    fun getRandomWordShuffled(word: String): MutableLiveData<String> {

        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)
        return liveData

    }


}