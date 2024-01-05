package com.example.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List: MutableList<ListViewModel>) : BaseAdapter() {
    // 리스트의 개수만큼
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // listView_item을 가져오는 부분
        var converView = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.listview_item, parent, false)

        // 받아온 List 데이터로 변경
        val title = converView.findViewById<TextView>(R.id.listviewItem)
        val content = converView.findViewById<TextView>(R.id.listviewItem2)
        title.text = List[position].title
        content.text = List[position].content

        return converView
    }

}