package com.example.goodwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView

class SentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("명언입니다. 1")
        sentenceList.add("명언입니다. 명업입니다.명언입니다. 명업입니다.")
        sentenceList.add("명언입니다. 2")
        sentenceList.add("명언입니다. 3.")


        val sentenceAdapter = ListViewAdapter(sentenceList)
        val listview = findViewById<ListView>(R.id.sentenceListView)
        listview.adapter = sentenceAdapter
    }
}