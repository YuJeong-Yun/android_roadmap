package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.ch6_workManager.lec6_WorkManagerTest.Companion.HowMuch

// WorkManager  -> 진행상태 검토?
// WorkManager -> 오래걸리는 작업 (60초 6 12 18 24 30) -> 몇 퍼센트 진행이 되었다

class lec6_WorkManager_work_progress_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec6_work_manager_work_progress)


        val workManagerTest = OneTimeWorkRequestBuilder<lec6_WorkManagerTest>().build()
        WorkManager.getInstance(this).enqueue(workManagerTest)

        // 데이터 주고받는 것과 비슷
        // 데이터는 모두 끝나도 전달했다면
        // 이거는 진행 중에 데이터를 계속 전달할 수 있음
        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this, Observer   { workInfo: WorkInfo? ->
                val progress = workInfo?.progress
                val value = progress?.getInt(HowMuch, 0)
                if (value != 0) {
                    Log.d("MainActivity", value.toString())
                }
                if (value == 100) {
                    Log.d("MainActivity", "이제 끝끝")
                }
            })

    }
}