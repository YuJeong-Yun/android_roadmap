package com.bokchi.ch4_jetpack_1.ch5_room

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class lec7_ViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = lec4_TextDatabase.getDatabase(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MainViewModel", db.textDao().getAllData().toString())
        Log.d("MainViewModel", db.wordDao().getAllData().toString())
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