package com.bokchi.ch4_jetpack_1.ch4_retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.bokchi.ch4_jetpack_1.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// https://developer.android.com/kotlin/coroutines?hl=ko
// https://myungpyo.medium.com/reading-coroutine-official-guide-thoroughly-part-0-20176d431e9d
class lec5_coroutine_viewModelScope_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec5_coroutine_view_model_scope)

        val goToSecond = findViewById<Button>(R.id.goToSecond)
        goToSecond.setOnClickListener {
            val intent = Intent(this, lec5_coroutine_viewModelScope_Second_Activity::class.java)
            startActivity(intent)
        }

//        Log.d("TEST", "START")
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.d("TEST", "CoroutineScope START")
//            a()
//            b()
//            Log.d("TEST", "CoroutineScope END")
//        }
//        Log.d("TEST", "END")
        /**
         * 실행순서
         * START -> END -> C START -> AP1 -> AP2 -> BP1 -> BP2 -> C END
         */


    }

    suspend fun a() {

        // a작업은 오래걸려서 2초정도
        delay(1000)
        Log.d("TEST", "AP1")

        delay(1000)
        Log.d("TEST", "AP2")
    }

    suspend fun b() {

        // b 작업은 오래걸려서 2초정도
        delay(1000)
        Log.d("TEST", "BP1")

        delay(1000)
        Log.d("TEST", "BP2")
    }

}