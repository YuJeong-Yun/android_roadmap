package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

// 워크매니저 + 코루틴 사용법
class lec5_WorkManager2(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {




        return Result.success()
    }

    suspend fun test1() {
        for (i in 1..3) {
            delay(1000)
            Log.d("WorkManager2 test1", i.toString())
        }
    }

    suspend fun test2() {
        for (i in 1..3) {
            delay(1000)
            Log.d("WorkManager2 test2", i.toString())
        }
    }

}