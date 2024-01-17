package com.example.trot_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter는 데이터와 RecyclerView 사이 통신을 위한 연결체
class RVAdapter(val items: MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    // 이 함수의 반환 수만 onBindViewHolder() 함수가 호출되어 항목을 만듦
    override fun getItemCount(): Int {
        return items.size
    }

    // viewHolder가 생성되는 함수
    // 여기서 반환한 뷰 홀더 객체는 자동으로 onBindViewHolder() 함수의 매개변수로 전달
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }

    // 매개변수로 전달된 뷰 홀더 객체의 뷰에 데이터를 출력하거나 필요한 이벤트를 등록한다.
    // 매개변수로 있는 position은 아이템중 지금 아이템이 몇번째 아이템인지 알려줍니다.
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }


    // 뷰홀더는 화면에 표시될 데이터나 아이템들을 저장하기 위한 역할 (뷰를 재활용하기 위해)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: String) {

            val rv_text = itemView.findViewById<TextView>(R.id.rvTextId)
            rv_text.text = item
        }

    }
}