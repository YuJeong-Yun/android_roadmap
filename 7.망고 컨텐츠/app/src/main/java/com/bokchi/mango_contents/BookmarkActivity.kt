package com.bokchi.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val contentModels = mutableListOf<ContentsModel>() // 디비에서 가져온 정보 저장할 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this, contentModels)
        recyclerview.adapter = rvAdapter

        recyclerview.layoutManager = GridLayoutManager(this, 2)

        //////////////////// 데이터베이스에서 가지고 오기 ////////////////////
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        myBookmarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) { // 데이터 가져오기 성공
                    for (dataModel in snapshot.children) {
                        Log.d("Datamodel", dataModel.toString())
                        contentModels.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }
                    rvAdapter.notifyDataSetChanged() // 새롭게 데이터를 동기화
                }

                override fun onCancelled(error: DatabaseError) { // 데이터 가져오기 실패
                    Log.e("Bookmark", "dbError")
                }

            })


    }
}