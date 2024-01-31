package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.bokchi.ch4_jetpack_1.R

// WorkManager 고유 작업
// 중복되지 않게 하나만 실행시킬 때
// https://developer.android.com/topic/libraries/architecture/workmanager/how-to/managing-work?hl=ko

class lec8_WorkManager_Unique_Work_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec8_work_manager_unique_work)

        val testBtn = findViewById<Button>(R.id.testBtn)
        testBtn.setOnClickListener {

            val testWorkManager = OneTimeWorkRequestBuilder<lec8_WorkManager>().build()
            // 기존에 했던 방식
//            WorkManager.getInstance(this).enqueue(testWorkManager)

            // 새로운방식
            // 옵션으로 이전 작업 어떻게 할지 설정 가능
//             WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)
            WorkManager.getInstance(this)
                .enqueueUniqueWork("test", ExistingWorkPolicy.REPLACE, testWorkManager)
        }


    }
}