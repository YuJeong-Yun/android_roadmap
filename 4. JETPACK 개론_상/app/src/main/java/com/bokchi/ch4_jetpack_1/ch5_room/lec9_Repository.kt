package com.bokchi.ch4_jetpack_1.ch5_room

import android.content.Context

class lec9_Repository(context: Context) {

    val db = lec4_TextDatabase.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insertTextData(text: String) = db.textDao().insert(lec4_TextEntity(0, text))

    fun insertWordData(text: String) = db.wordDao().insert(lec6_WordEntity(0, text))

    fun deleteTextData() = db.textDao().deleteAllData()

    fun deleteWordData() = db.wordDao().deleteAllData()

}