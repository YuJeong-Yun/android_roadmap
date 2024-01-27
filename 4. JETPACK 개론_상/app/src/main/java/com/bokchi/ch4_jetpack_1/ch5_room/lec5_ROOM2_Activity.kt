package com.bokchi.ch4_jetpack_1.ch5_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.bokchi.ch4_jetpack_1.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class lec5_ROOM2_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec5_room2)

        val db = lec4_TextDatabase.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.textInputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(lec4_TextEntity(0, inputArea.text.toString()))
                inputArea.setText("")
            }

        }

        getAllBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("MAINACTIVITY", db.textDao().getAllData().toString())
            }
        }

        deleteBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
            }
        }
    }
}