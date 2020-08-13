package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main7.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        val data = getData()
        smrfl.setOnRefreshListener {
            Handler().postDelayed({
                smrfl.finishRefresh()
            },2000)
        }
        smrfl.setOnLoadMoreListener {
            Handler().postDelayed({
                smrfl.finishLoadMore()
            },2000)
        }
        val adapter=RecyclerItemAdpater(this,data)
        val ml=GridLayoutManager(this,1)
        rlv_item_content.layoutManager=ml
        rlv_item_content.adapter=adapter
    }

    private fun getData():MutableList<Good> {
        val list = mutableListOf<Good>()
        var good:Good
        var childs:MutableList<ChildGood>
        for (index in 0 until 20){
            var childGood:ChildGood
            childs= mutableListOf()
            for (child in 0 until 5){
                childGood=ChildGood("子类名字$child",child)
                childs.add(childGood)
            }
            good=Good("父类名字$index",index,childs)
            list.add(good)
        }
        return list
    }
}