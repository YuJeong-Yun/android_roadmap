package com.example.goodwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.goodwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("명언입니다. 1")
        sentenceList.add("명언입니다. 명업입니다.명언입니다. 명업입니다.")
        sentenceList.add("명언입니다. 2")
        sentenceList.add("명언입니다. 3.")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.showAllSentence.setOnClickListener {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }

        binding.goodWordTextArea.setText(sentenceList.random())

    }
}