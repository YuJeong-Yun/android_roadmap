package com.bokchi.fb_login_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    // 파이어베이스에서 프로젝트 만들고 필요한 파일 추가해주고
    // https://firebase.google.com/docs/auth/android/anonymous-auth?hl=ko (구글에서 파이어베이스 익명 로그인 검색)
    // 여기에서 필요한 부분 또 추가 필요

    // os 버전 오류 뜨면
    // manifests/AndoridManifest.xml 파일에서
    // MainActivity에 exported=true 구문 추가

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val btn = findViewById<Button>(R.id.noEmailLoginBtn)
        btn.setOnClickListener {

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {


                        val user = auth.currentUser

                        Log.d("MainActivity", user!!.uid)

                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT)
                            .show()

                    }
                }

        }


    }
}