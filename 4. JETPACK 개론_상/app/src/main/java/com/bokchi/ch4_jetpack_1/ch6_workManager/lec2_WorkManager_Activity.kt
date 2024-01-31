package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.bokchi.ch4_jetpack_1.R

// https://developer.android.com/topic/libraries/architecture/workmanager
// https://developer.android.com/codelabs/android-workmanager#0

class lec2_WorkManager_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec2_work_manager)

        SimpleThread().start()

        val workManagerA = OneTimeWorkRequestBuilder<lec2_WorkManagerA>().build()
        WorkManager.getInstance(this).enqueue(workManagerA)
    }
}

class SimpleThread : Thread() {

    override fun run() {
        super.run()

        for (i in 1..10) {
            Log.d("MainActivity", "$i")
            sleep(1000)
        }

    }

}