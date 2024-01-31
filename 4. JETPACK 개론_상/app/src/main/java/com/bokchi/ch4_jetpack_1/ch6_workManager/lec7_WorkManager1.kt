package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class lec7_WorkManager1(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {

        Log.d("WorkManager1", "doWork")

        // 실행 시간 확인 위해 찍어줌
        val format = SimpleDateFormat("hh:mm:ss")
        val currentTime = format.format(Date())

        Log.d("WorkManager1", currentTime)

        return Result.success()

    }
}