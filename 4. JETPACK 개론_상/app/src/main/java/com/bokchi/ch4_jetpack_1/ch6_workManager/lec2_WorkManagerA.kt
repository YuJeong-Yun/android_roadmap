package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class lec2_WorkManagerA(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {

        for (i in 1..10) {
            sleep(1000)
            Log.d("WorManagerA", i.toString())
        }

        return Result.success()
    }


}