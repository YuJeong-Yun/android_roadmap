package com.bokchi.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// 아이템 클릭시 넘어올 액티비티
class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)


        //////////////////// 웹 뷰 띄우기 ////////////////////
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url").toString())

        //////////////////// db에 북마크 저장 ////////////////////
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref") // db에서 저장할 장소(테이블 느낌)

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageUrl = intent.getStringExtra("imageUrl").toString()

        val saveText = findViewById<TextView>(R.id.saveText) // 저장 버튼
        saveText.setOnClickListener {
            myBookmarkRef // db에 데이터 저장
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(ContentsModel(url, imageUrl, title)) // db에 북마크한 contentsModel 객체 전부 저장

        }




    }
}