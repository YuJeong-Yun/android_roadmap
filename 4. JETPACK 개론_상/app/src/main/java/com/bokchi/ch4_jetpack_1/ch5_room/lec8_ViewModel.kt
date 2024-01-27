package com.bokchi.ch4_jetpack_1.ch5_room

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class lec8_ViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = lec4_TextDatabase.getDatabase(context)

    private var _textList = MutableLiveData<List<lec4_TextEntity>>()
    val textList: LiveData<List<lec4_TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<lec6_WordEntity>>()
    val wordList: LiveData<List<lec6_WordEntity>>
        get() = _wordList

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MainViewModel", db.textDao().getAllData().toString())
        Log.d("MainViewModel", db.wordDao().getAllData().toString())
        _textList.postValue(db.textDao().getAllData())
        _wordList.postValue(db.wordDao().getAllData())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().insert(lec4_TextEntity(0, text))
        db.wordDao().insert(lec6_WordEntity(0, text))
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAllData()
        db.wordDao().deleteAllData()
    }


}