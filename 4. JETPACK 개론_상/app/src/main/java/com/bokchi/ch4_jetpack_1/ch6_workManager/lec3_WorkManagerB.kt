package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class lec3_WorkManagerB(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        // 워크매니저에서 데이터 받는 법
        val a = inputData.getInt("a", 1000)
        val b = inputData.getInt("b", 2000)
        val c = inputData.getInt("c", 3000)

        Log.d("WorkManagerB", a.toString())
        Log.d("WorkManagerB", b.toString())
        Log.d("WorkManagerB", c.toString())

        val output: Data = workDataOf("result" to 10)

        return Result.success(output)

    }


}