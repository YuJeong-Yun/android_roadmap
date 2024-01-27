package com.bokchi.ch4_jetpack_1.ch5_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.ch4_jetpack_1.R

class lec8_ROOM_ViewModelScope_LiveData_RV_Activity : AppCompatActivity() {

    lateinit var viewModel: lec8_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec8_room_view_model_scope_live_data_rv)

        viewModel = ViewModelProvider(this).get(lec8_ViewModel::class.java)
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

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.textList.observe(this, Observer {
            val customAdapter = lec8_CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })

        getAllBtn.setOnClickListener {
            viewModel.getData()
        }

        deleteBtn.setOnClickListener {
            viewModel.removeData()
        }

    }
}