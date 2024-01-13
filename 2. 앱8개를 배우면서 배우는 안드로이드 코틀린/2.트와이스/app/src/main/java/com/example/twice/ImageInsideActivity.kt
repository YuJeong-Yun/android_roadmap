package com.example.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getData = intent.getStringExtra("data")

//        Toast.makeText(this, getData, Toast.LENGTH_LONG).show()

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        when (getData) {
            "1" -> memberImage.setImageResource(R.drawable.member_1)
            "2" -> memberImage.setImageResource(R.drawable.member_2)
            "3" -> memberImage.setImageResource(R.drawable.member_3)
        }

    }
}