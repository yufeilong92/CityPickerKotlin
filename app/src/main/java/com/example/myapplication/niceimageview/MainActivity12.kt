package com.example.myapplication.niceimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main12.*

class MainActivity12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)
        Glide.with(this)
            .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598519753992&di=8f98e74f7c42a47be17ece50eaf50ebc&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg")
            .centerCrop()
            .into(nice_iv6)
        Glide.with(this)
            .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598519753992&di=8f98e74f7c42a47be17ece50eaf50ebc&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg")
            .into(iv_main22)

    }
}