package com.bokchi.ch4_jetpack_1.ch5_room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class lec9_ViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = lec4_TextDatabase.getDatabase(context)

    private var _textList = MutableLiveData<List<lec4_TextEntity>>()
    val textList: LiveData<List<lec4_TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<lec6_WordEntity>>()
    val wordList: LiveData<List<lec6_WordEntity>>
        get() = _wordList

    val repository = lec9_Repository(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
//        Log.d("MainViewModel", db.textDao().getAllData().toString())
//        Log.d("MainViewModel", db.wordDao().getAllData().toString())
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
//        db.textDao().insert(TextEntity(0, text))
//        db.wordDao().insert(WordEntity(0, text))
        repository.insertTextData(text)
        repository.insertWordData(text)
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
//        db.textDao().deleteAllData()
//        db.wordDao().deleteAllData()
        repository.deleteTextData()
        repository.deleteWordData()
    }

}