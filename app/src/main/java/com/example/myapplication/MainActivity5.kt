package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main9.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        bindViewData()
    }

    private fun bindViewData() {
        val list = mutableListOf<String>()
        for (item in 0..200) {
            list.add("$item")
        }
        val adaapter = TestAdapter(this,list)
        val mll=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
        rlv_main6_content.layoutManager=mll
        rlv_main6_content.adapter=adaapter

        val hasp=HashMap<Any,Any?>()

    }


}