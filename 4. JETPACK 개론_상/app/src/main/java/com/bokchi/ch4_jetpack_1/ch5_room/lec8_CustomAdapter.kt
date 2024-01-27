package com.bokchi.ch4_jetpack_1.ch5_room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.ch4_jetpack_1.R

class lec8_CustomAdapter(private val dataSet: List<lec4_TextEntity>) :
    RecyclerView.Adapter<lec8_CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): lec8_CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lec8_room_text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: lec8_CustomAdapter.ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].text
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}