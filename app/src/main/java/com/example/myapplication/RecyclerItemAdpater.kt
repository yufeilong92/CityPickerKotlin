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
 * @Time :2020/7/23 9:10
 * @Purpose :测试
 */
class RecyclerItemAdpater(var mContext: Context, var data: MutableList<Good>) :
    RecyclerView.Adapter<RecyclerItemAdpater.GoodViewHolde>() {
    private var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    class GoodViewHolde(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_p_name)
        var itemlist = view.findViewById<ItemListView>(R.id.li_item_list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerItemAdpater.GoodViewHolde {
        return GoodViewHolde(mInflater!!.inflate(R.layout.good_item, null))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerItemAdpater.GoodViewHolde, position: Int) {
        val vo = data[position]
        holder.tvName.text = vo.pName
        holder.itemlist.setItemList(mContext,R.layout.item_child, vo.childs) { view, postion, childGood ->
            val tvChildName = view.findViewById<TextView>(R.id.tv_child_name)
            tvChildName.text = childGood.name
        }


    }
}