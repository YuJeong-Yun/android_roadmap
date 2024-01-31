package com.bokchi.ch4_jetpack_1.ch6_workManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.bokchi.ch4_jetpack_1.R

// WorkManager Chaining

// A -> 순서 상관 없이 실행되도 괜찮음
// B -> 순서 상관 없이 실행되도 괜찮음
// C -> 무조건 A / B 모두 실행 된 뒤에 실행되어야 한다

class lec4_WorkManagerChaining_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec3_work_manager_chaining)


        val workManagerA = OneTimeWorkRequestBuilder<lec2_WorkManagerA>().build()
        val workManagerB = OneTimeWorkRequestBuilder<lec3_WorkManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<lec4_WorkManagerC>().build()

//        기존 방식
//        WorkManager.getInstance(this).enqueue(workManagerA)
//        WorkManager.getInstance(this).enqueue(workManagerB)
//        WorkManager.getInstance(this).enqueue(workManagerC)

        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerA, workManagerB))
            .then(workManagerC)
            .enqueue()

    }
}