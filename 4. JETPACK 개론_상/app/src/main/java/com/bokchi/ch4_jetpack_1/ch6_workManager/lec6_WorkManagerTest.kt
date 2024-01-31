package com.bokchi.ch4_jetpack_1.ch6_workManager

import android.content.Context
import androidx.databinding.adapters.SeekBarBindingAdapter.setProgress
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay

class lec6_WorkManagerTest(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    companion object {
        const val HowMuch = "progress"
    }

    override suspend fun doWork(): Result {

        // i -> 1,2,3,4,5,6,7,8,9,10 / 10 20 30 40 .. 100 퍼센트 값으로 나타내려고 *10 해줌
        for (i in 1..10) {
            val result = workDataOf(HowMuch to i * 10)
            setProgress(result)
            delay(1000)
        }

        return Result.success()

    }

}