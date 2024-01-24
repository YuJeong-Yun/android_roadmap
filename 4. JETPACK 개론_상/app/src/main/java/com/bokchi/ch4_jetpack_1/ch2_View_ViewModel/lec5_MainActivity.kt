package com.bokchi.ch4_jetpack_1.ch2_View_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R

/**
 *  Repository
 *  네트워크 통신을 하거나
 *
 *  LocalDB
 *  Room SQLite
 *
 *  이러한 정보를 Activity에서 ViewModel에 넘겨주고 싶을 때 ViewModelFactory 사용
 */
class lec5_MainActivity : AppCompatActivity() {

    lateinit var viewModel: lec5_ViewModel
    lateinit var viewModelFactory: lec5_ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec5_main)

        viewModelFactory = lec5_ViewModelFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory).get(lec5_ViewModel::class.java)

    }
}