package com.bokchi.mango_contents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// context : 글라이드 라이브러리 사용 위해 필요. MainActivity에서는 그냥 쓸 수 있음(프로그램의 맥락과 비슷한 의미)
class RVAdapter(val context: Context, val List: MutableList<ContentsModel>) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(v)
    }

    // 아이템 클릭시 이벤트 주기 위해 추가한 부분
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        if (itemClick != null) {
            holder.itemView.setOnClickListener { v ->
                itemClick!!.onClick(v, position)
            }
        }
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: ContentsModel) {
            val rv_text = itemView.findViewById<TextView>(R.id.rvTextArea)
            val rv_img = itemView.findViewById<ImageView>(R.id.rvImageArea)

            rv_text.text = item.titleText
            // 글라이드 라이브러리 사용해 이미지 로드하면 자동 캐싱해서 성능 향상에 도움
            Glide.with(context).load(item.imageUrl).into(rv_img)
        }
    }


}