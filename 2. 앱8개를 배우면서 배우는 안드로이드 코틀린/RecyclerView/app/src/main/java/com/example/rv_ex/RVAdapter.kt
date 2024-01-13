package com.example.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items: MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 데이터 매핑
        fun bindItems(item: String) {
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item

        }
    }

    // 각각의 요소에 setOnClick 이벤트 걸어주기 위해 생성
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }

    // 전체 리사이클러뷰의 개수
    override fun getItemCount(): Int {
        return items.size
    }

    // 어댑터에서 받아온 데이터를 rv_item에 담아 Activity_sentence에 넣어주는 작업
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (itemClick != null) {
            holder.itemView.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItems(items[position])
    }
}
