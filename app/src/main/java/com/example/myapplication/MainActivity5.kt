package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main9.*
import java.util.regex.Matcher
import java.util.regex.Pattern

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


    }


}