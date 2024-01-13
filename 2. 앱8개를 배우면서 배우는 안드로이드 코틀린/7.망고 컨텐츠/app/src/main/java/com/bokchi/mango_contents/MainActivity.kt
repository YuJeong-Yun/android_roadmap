package com.bokchi.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // 외부에서 이미지 파일 받아오려면 이미지 필요
    // manifests/AndroidManifest.xml 에서 설정

    private val items = mutableListOf<ContentsModel>() // RVAdapter에서 받을 데이터 리스트

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////////////////// 북마크 클릭 시 ////////////////////
        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        //////////////////// RVAdapter에 전달할 데이터 담기 ////////////////////
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
                "https://mp-seoul-image-production-s3.mangoplate.com/331247/60039_1596540913676_34054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴욕택시디저트"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/bKBEWmF8MVGb",
                "https://mp-seoul-image-production-s3.mangoplate.com/705256_1562413869818147.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "동경산책"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/pVydRWGId3d8",
                "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/398605/1062290_1606269461021?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피자보이시나"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mmhYgR5FVnYH",
                "https://mp-seoul-image-production-s3.mangoplate.com/516849_1579437536418491.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "경원치킨"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
                "https://mp-seoul-image-production-s3.mangoplate.com/331247/60039_1596540913676_34054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴욕택시디저트"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/bKBEWmF8MVGb",
                "https://mp-seoul-image-production-s3.mangoplate.com/705256_1562413869818147.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "동경산책"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/pVydRWGId3d8",
                "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/398605/1062290_1606269461021?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피자보이시나"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mmhYgR5FVnYH",
                "https://mp-seoul-image-production-s3.mangoplate.com/516849_1579437536418491.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "경원치킨"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this, items)
        recyclerview.adapter = rvAdapter

        ////////////////////////////// 웹 뷰 //////////////////////////////
        // 아이템 클릭시 새로운 액티비티로(웹뷰) 이동 이벤트 주기 위해 추가한 부분
        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                // 선택한 아이템의 정보 담아서 액티비티 이동. 해당 액티비티에서 웹 뷰 띄워줌!
                // 북마크할 때 저장할 정보 필요해서 여기서 url외 정보도 모두 담아감
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)

                startActivity(intent)
            }
        }

        // LinearLayoutManager 대신 GridLayoutManager 쓰면
        // 한 줄에 항목 2개씩 나옴
        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}