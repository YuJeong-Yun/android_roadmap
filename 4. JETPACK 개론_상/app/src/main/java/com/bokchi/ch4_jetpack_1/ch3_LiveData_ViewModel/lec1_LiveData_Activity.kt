package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bokchi.ch4_jetpack_1.R

// LiveData
// https://developer.android.com/topic/libraries/architecture/livedata

// LiveData - 데이터를 관찰해줄 수 있는 친구(LifeCycle 과 결합해서)
class lec1_LiveData_Activity : AppCompatActivity() {


    private var testMutableLiveData = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec1_live_data)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
        }

        // 값을 관찰
        // 즉 testMutableLiveData 가 바뀔 때 마다 이 부분이 실행됨
        testMutableLiveData.observe(this, Observer {
            Log.d("testMutableLiveData", testMutableLiveData.value.toString())
            findViewById<TextView>(R.id.textArea).text = testMutableLiveData.value.toString()
        })
    }
}