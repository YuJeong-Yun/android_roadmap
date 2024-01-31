package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

// 기존 워크매니저 생성 방식
class lec5_WorkManager1(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {

        return Result.success()
    }
}