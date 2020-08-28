package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main13.*

class MainActivity13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)
        val mCountDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onFinish() {
                tv_main_time.text = "结束了"
            }

            override fun onTick(p0: Long) {
                tv_main_time.text = "${getKNumber(4,p0.toInt(),100)}"
            }

        }
        tv_main_13.setOnClickListener {
            mCountDownTimer.start()
        }
        tv_main_time.setOnClickListener {
            mCountDownTimer.start()
        }
    }
    fun getKNumber(k: Int, num: Int,number:Int): Int {
        //如果k越界，则返回-1
        return if (Math.pow(10.0, k - 1.toDouble()) > num) {
            -1
        } else {
            num / Math.pow(10.0, k - 1.toDouble()).toInt() % number
        }
    }
}