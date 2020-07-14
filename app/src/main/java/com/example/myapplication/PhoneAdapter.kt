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
 * @Time :2020/7/14 9:19
 * @Purpose :
 */
class PhoneAdapter(var mContext: Context, var data: MutableList<String>) :
    RecyclerView.Adapter<PhoneAdapter.ViewModel>() {
    private var mLayoutlnInflater: LayoutInflater? = null

    init {
        mLayoutlnInflater = LayoutInflater.from(mContext)
    }

    class ViewModel(view: View) : RecyclerView.ViewHolder(view) {
        val tv = view.findViewById<TextView>(R.id.tv_phone_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneAdapter.ViewModel {
        return ViewModel(mLayoutlnInflater!!.inflate(R.layout.itemphone, null))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PhoneAdapter.ViewModel, position: Int) {
        holder.tv.text=data[position]
    }
}