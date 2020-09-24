package com.example.myapplication

import android.content.Context
import android.widget.BaseAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/8/21 15:32
 * @Purpose :
 */
class TestAdapter(mContext: Context, data: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_text, data) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_text_content, item)
            .setText(R.id.tv_text_contentone,item)
            .setText(R.id.tv_text_contenttwo,item)
    }
}