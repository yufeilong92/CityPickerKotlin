package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import org.xmlpull.v1.XmlPullParser
import java.util.jar.Attributes

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/7/23 9:02
 * @Purpose :item子类数据
 */
class ItemListView: LinearLayout {
    constructor(mContext: Context,attributes: AttributeSet?):super(mContext,attributes)
    init {
        orientation = LinearLayout.VERTICAL
    }

    fun <T> setItemList(
        mContext: Context,
        childView:Int,
        datas: MutableList<T>?,
        bindItemData: (view: View, postion: Int, T) -> Unit
    ) {
        if (datas.isNullOrEmpty()) return
        removeAllViews()
        datas.forEachIndexed { index, t ->
            val view = LayoutInflater.from(mContext).inflate(childView, null, false)
            bindItemData(view, index, t)
            addView(view)
        }
    }
}