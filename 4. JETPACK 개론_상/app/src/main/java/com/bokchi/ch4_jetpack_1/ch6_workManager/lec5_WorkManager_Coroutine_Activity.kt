package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.bokchi.ch4_jetpack_1.R

// WorkManager + Coroutine
class lec5_WorkManager_Coroutine_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec5_work_manager_coroutine)

        val workManager = OneTimeWorkRequestBuilder<lec5_WorkManager2>().build()
        WorkManager.getInstance(this).enqueue(workManager)

    }
}