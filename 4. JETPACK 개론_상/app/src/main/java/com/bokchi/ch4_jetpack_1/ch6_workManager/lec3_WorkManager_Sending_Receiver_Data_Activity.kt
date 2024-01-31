package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.bokchi.ch4_jetpack_1.R

// WorkManager로 데이터 주고
// 작업 완료 후 데이터 받기
class lec3_WorkManager_Sending_Receiver_Data_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec3_work_manager_sending_receiver_data)

//        val workManagerA = OneTimeWorkRequestBuilder<WorManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        val myData: Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        val workManagerB =
            OneTimeWorkRequestBuilder<lec3_WorkManagerB>().setInputData(myData).build()
        WorkManager.getInstance(this).enqueue(workManagerB)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this, Observer { info ->

                if (info != null && info.state.isFinished) {

                    val result = info.outputData.getInt("result", 10000)
                    val result2 = info.outputData.getInt("result2", 10000)
                    Log.d("MainActivity", result.toString())
                    Log.d("MainActivity", result2.toString())
                }
            })
    }
}