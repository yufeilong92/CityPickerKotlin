package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/7/2 15:28
 * @Purpose :
 */
class MainAdapter(var mContext: Context, var list: MutableList<String>) :
    RecyclerView.Adapter<MainAdapter.ViewHolde>() {
    var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    class ViewHolde(val item: View) : RecyclerView.ViewHolder(item) {
        val tv = item.findViewById<TextView>(R.id.tv_item_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolde {
        return ViewHolde(mInflater!!.inflate(R.layout.item_layout, null))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolde, position: Int) {
        holder.tv.text = list[position]
    }
}