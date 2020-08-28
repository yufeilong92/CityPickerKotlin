package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.util.AnimationUtils
import kotlinx.android.synthetic.main.activity_main13.*

class MainActivity13 : AppCompatActivity() {
    private lateinit var mListener: TestInterface

    fun setInface(listener: TestInterface) {
        this.mListener = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)
        val mCountDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onFinish() {
                tv_main_time.text = "结束了"
            }

            override fun onTick(p0: Long) {
                tv_main_time.text = "${getKNumber(4, p0.toInt(), 100)}"
            }

        }
        tv_main_13.setOnClickListener {
            mCountDownTimer.start()
        }
        tv_main_time.setOnClickListener {
            mCountDownTimer.start()
        }
        btn_send_annim.setOnClickListener {
            val rotateAnimationByCenter = AnimationUtils.getRotateAnimationByCenter()
            btn_send_annim.startAnimation(rotateAnimationByCenter)
        }
        btn_send_annimOne.setOnClickListener {
            val alpha = AnimationUtils.getAlphaAnimation(1.0f, 0.0f, 1000)
            btn_send_annimOne.startAnimation(alpha)

        }
        btn_send_annimTwo.setOnClickListener {
            val amplificationAnimation = AnimationUtils.getAmplificationAnimation(1000)
            btn_send_annimTwo.startAnimation(amplificationAnimation)
        }
        btn_send_annimthree.setOnClickListener {

        }
        btn_send_annimfour.setOnClickListener {

        }
        btn_send_annimfive.setOnClickListener {
            val m=MainActivity13()
            m.setInface(object :TestInterface{
                override fun onClick(postion: Int) {

                }

                override fun onItemClick() {
                }

            })
        }
    }

    fun getKNumber(k: Int, num: Int, number: Int): Int {
        //如果k越界，则返回-1
        return if (Math.pow(10.0, k - 1.toDouble()) > num) {
            -1
        } else {
            num / Math.pow(10.0, k - 1.toDouble()).toInt() % number
        }
    }
}