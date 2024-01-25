package com.bokchi.ch4_jetpack_1.ch4_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.ch4_jetpack_1.R

class lec7_CustomAdapter(private val dataSet: ArrayList<lec2_Post>) :
    RecyclerView.Adapter<lec7_CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): lec7_CustomAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.lec7_text_row_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: lec7_CustomAdapter.ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].title
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}