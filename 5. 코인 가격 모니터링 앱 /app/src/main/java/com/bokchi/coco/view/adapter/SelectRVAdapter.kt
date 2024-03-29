package com.bokchi.coco.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.coco.R
import com.bokchi.coco.dataModel.CurrentPriceResult
import timber.log.Timber

class SelectRVAdapter(val context : Context, val coinPriceList : List<CurrentPriceResult>)
    :RecyclerView.Adapter<SelectRVAdapter.ViewHolder>(){

    // 좋아요한 코인 목록 담을 리스트
    val selectedCoinList = ArrayList<String>()

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val coinName : TextView = view.findViewById(R.id.coinName)
        val coinPriceUpDown : TextView = view.findViewById(R.id.coinPriceUpDown)
        val likeImage : ImageView = view.findViewById(R.id.likeBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_coin_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 코인 이름
        holder.coinName.text = coinPriceList[position].coinName

        // 상승,하락 여부
        val fluctate_24H = coinPriceList[position].coinInfo.fluctate_24H

        if(fluctate_24H.contains("-")) {
            holder.coinPriceUpDown.text = "하락입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#114fed"))
        } else {
            holder.coinPriceUpDown.text = "상승입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
        }

        // 하트 이미지
        val likeImage = holder.likeImage
        val currentCoin = coinPriceList[position].coinName

        // 리사이클러뷰는 뷰를 재활용하므로 아래 처리 필요!
        // view 를 그려줄 때
        if(selectedCoinList.contains(currentCoin)) {
            likeImage.setImageResource(R.drawable.like_red)
        } else {
            likeImage.setImageResource(R.drawable.like_grey)
        }

        likeImage.setOnClickListener {
            Timber.d(currentCoin)

            if(selectedCoinList.contains(currentCoin)) {
                // 포함하면
                selectedCoinList.remove(currentCoin)
                likeImage.setImageResource(R.drawable.like_grey)
            } else {
                // 포함하지 않으면
                selectedCoinList.add(currentCoin)
                likeImage.setImageResource(R.drawable.like_red)
            }
            Timber.d(selectedCoinList.toString())
        }


    }

    override fun getItemCount(): Int {
        return coinPriceList.size
    }
}