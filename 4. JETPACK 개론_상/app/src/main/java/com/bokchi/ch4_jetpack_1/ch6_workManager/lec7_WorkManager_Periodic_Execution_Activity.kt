package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.bokchi.ch4_jetpack_1.R
import java.util.concurrent.TimeUnit

// 주기적 실행
// 15분마다 / 30분다 / 1시간마다
class lec7_WorkManager_Periodic_Execution_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec7_work_manager_periodic_execution)

        // 최소값 15분
        val workManager =
            PeriodicWorkRequestBuilder<lec7_WorkManager1>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workManager)

    }
}