package com.bokchi.ch4_jetpack_1.ch5_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R

class lec7_ROOM_ViewModelScope_Activity : AppCompatActivity() {

    lateinit var viewModel: lec7_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec7_room3_view_model_scope_activity)

        viewModel = ViewModelProvider(this).get(lec7_ViewModel::class.java)
        viewModel.getData()

        val db = lec4_TextDatabase.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.textInputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {
            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")
        }

        getAllBtn.setOnClickListener {
            viewModel.getData()
        }

        deleteBtn.setOnClickListener {
            viewModel.removeData()
        }


    }
}