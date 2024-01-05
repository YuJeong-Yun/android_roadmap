package com.example.trot_list

import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class Singer1Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_singer1, container, false)

        // 리사이클러뷰 연결
        val items = mutableListOf<String>()
        items.add("노래1")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래2")
        items.add("노래3")
        items.add("노래4")

        val rv = view.findViewById<RecyclerView>(R.id.singRv)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)
        //////////////

        view.findViewById<ImageView>(R.id.image2).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer2Fragment)
        }

        view.findViewById<ImageView>(R.id.image3).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer3Fragment)
        }


        return view
    }

}