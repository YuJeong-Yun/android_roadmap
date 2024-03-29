package com.bokchi.diet_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.bokchi.diet_memo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        try {
            Log.d("SPLASH", auth.currentUser!!.uid) // 로그인 안되어있으면 여기서 오류 발생
            Toast.makeText(this, "원래 비회원 로그인이 되어있는 사람입니다!", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)

        } catch (e: Exception) {
            Log.d("SPLASH", "회원가입 시켜줘야함")

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) { // 익명 로그인 성공 시
                        Toast.makeText(this, "비회원 로그인 성공", Toast.LENGTH_LONG).show()

                        Handler().postDelayed({
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }, 3000)
                    } else { // 익명 로그인 실패
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "비회원 로그인 실패", Toast.LENGTH_LONG).show()
                    }
                }

        }


    }
}