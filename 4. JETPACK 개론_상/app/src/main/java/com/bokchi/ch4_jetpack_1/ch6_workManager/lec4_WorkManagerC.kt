package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class lec4_WorkManagerC(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {

        for (i in 0..3) {
            Thread.sleep(1000)
            Log.d("WorkManagerC", i.toString())
        }

        return Result.success()

    }
}