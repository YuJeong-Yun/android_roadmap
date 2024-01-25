package com.bokchi.ch4_jetpack_1.ch4_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R
import kotlin.math.log

class lec5_coroutine_viewModelScope_Second_Activity : AppCompatActivity() {

    lateinit var viewModel: lec5_second_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec5_coroutine_view_model_scope_second)

        viewModel = ViewModelProvider(this).get(lec5_second_ViewModel::class.java)
        viewModel.a()
        viewModel.b()

    }
}