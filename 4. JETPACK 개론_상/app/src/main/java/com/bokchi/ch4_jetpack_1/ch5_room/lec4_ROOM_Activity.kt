package com.bokchi.ch4_jetpack_1.ch5_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bokchi.ch4_jetpack_1.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// https://developer.android.com/training/data-storage/room?hl=ko
// https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=ko#5
/**
 * 프로젝트에 추가
 *  id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
 *
 *  모듈에 추가
 *    id("com.google.devtools.ksp")
 *        // ROOM
 *     val room_version = "2.5.0"
 *
 *     implementation("androidx.room:room-runtime:$room_version")
 *     annotationProcessor("androidx.room:room-compiler:$room_version")
 *
 *     // To use Kotlin Symbol Processing (KSP)
 *     ksp("androidx.room:room-compiler:$room_version")
 *
 *     // optional - Kotlin Extensions and Coroutines support for Room
 *     implementation("androidx.room:room-ktx:$room_version")
 */

class lec4_ROOM_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec4_room)

        val db = lec4_TextDatabase.getDatabase(this)


        CoroutineScope(Dispatchers.IO).launch {
            db.textDao().insert(lec4_TextEntity(0, "HELLO"))
            Log.d("MAINACTIVITY", db.textDao().getAllData().toString())

        }
    }
}