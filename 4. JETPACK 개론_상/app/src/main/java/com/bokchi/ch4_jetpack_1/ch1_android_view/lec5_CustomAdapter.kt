package com.bokchi.ch4_jetpack_1.ch1_android_view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.Lec4TextRowItemBinding

class lec5_CustomAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<lec5_CustomAdapter.ViewHolder>() {

    class ViewHolder(binding: Lec4TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val myText: TextView = binding.myText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

//         val view = Lec4TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view = DataBindingUtil.inflate<Lec4TextRowItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.lec4_text_row_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}