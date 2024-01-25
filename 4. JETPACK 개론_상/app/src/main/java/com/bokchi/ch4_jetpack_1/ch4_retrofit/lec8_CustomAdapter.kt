package com.bokchi.ch4_jetpack_1.ch4_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.ch4_jetpack_1.R
import com.bumptech.glide.Glide

class lec8_CustomAdapter(val context: Context, val dataSet: List<lec8_Plant>) :
    RecyclerView.Adapter<lec8_CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textArea)
        val imageView: ImageView = view.findViewById(R.id.imageArea)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): lec8_CustomAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.lec8_text_row_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: lec8_CustomAdapter.ViewHolder, position: Int) {

        holder.textView.text = dataSet[position].name
        Glide.with(context).load(dataSet[position].imageUrl).into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}