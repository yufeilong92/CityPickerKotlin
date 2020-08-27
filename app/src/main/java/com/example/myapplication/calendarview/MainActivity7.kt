package com.example.myapplication.calendar

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.calendarview.MainActivity11
import com.othershe.calendarview.utils.CalendarUtil
import kotlinx.android.synthetic.main.activity_main10.*
import java.util.*

class MainActivity7 : AppCompatActivity() {
    private val cDate = CalendarUtil.getCurrentDate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)
        initEvent()
        initListener()
        initViewModel()
    }

    private fun initEvent() {
        val map =
            HashMap<String, String>()
        map["2017.10.30"] = "qaz"
        map["2017.10.1"] = "wsx"
        map["2017.11.12"] = "yhn"
        map["2017.9.15"] = "edc"
        map["2017.11.6"] = "rfv"
        map["2017.11.11"] = "tgb"

        calendar.setStartEndDate("2015.1","2028.12")
            .setDisableStartEndDate("2016.10.10", "2028.10.10")
            .setInitDate("${cDate[0]}.${cDate[1]}")
            .setSingleDate("${cDate[0]}.${cDate[1]}.${cDate[2]}")
            .init();
        tv_title.text= cDate[0].toString() + "年" + cDate[1] + "月"
        choose_date.text= "当前选中的日期：" + cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日"
    }

    private fun initListener() {
        calendar.setOnPagerChangeListener {date->
            tv_title.text= date.get(0).toString() + "年" + date.get(1) + "月"
        }
        calendar.setOnSingleChooseListener { view, date ->
            tv_title.text= date.solar[0].toString() + "年" + date.solar[1] + "月"
            if (date.type==1){
                choose_date.text=
                    "当前选中的日期：" + date.solar[0] + "年" + date.solar[1] + "月" + date.solar[2] + "日"
            }
        }
    }

    private fun initViewModel() {

    }

    fun someday(v: View?) {
        val view: View =
            LayoutInflater.from(this@MainActivity7).inflate(R.layout.input_layout, null)
        val year = view.findViewById<View>(R.id.year) as EditText
        val month = view.findViewById<View>(R.id.month) as EditText
        val day = view.findViewById<View>(R.id.day) as EditText
        AlertDialog.Builder(this)
            .setView(view)
            .setPositiveButton("确定", DialogInterface.OnClickListener { dialog, which ->
                if (TextUtils.isEmpty(year.text)
                    || TextUtils.isEmpty(month.text)
                    || TextUtils.isEmpty(day.text)
                ) {
                    Toast.makeText(this@MainActivity7, "请完善日期！", Toast.LENGTH_SHORT).show()
                    return@OnClickListener
                }
                val result: Boolean = calendar.toSpecifyDate(
                    Integer.valueOf(year.text.toString()),
                    Integer.valueOf(month.text.toString()),
                    Integer.valueOf(day.text.toString())
                )
                if (!result) {
                    Toast.makeText(this@MainActivity7, "日期越界！", Toast.LENGTH_SHORT).show()
                } else {
                    choose_date.setText("当前选中的日期：" + year.text + "年" + month.text + "月" + day.text + "日")
                }
                dialog.dismiss()
            })
            .setNegativeButton("取消", null).show()
    }

    fun today(view: View?) {
        calendar.today()
        choose_date.setText("当前选中的日期：" + cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日")
    }
    fun multiChoose(view: View?) {
        startActivity(Intent(this@MainActivity7, MainActivity11::class.java))
    }

    fun lastMonth(view: View?) {
        calendar.lastMonth()
    }

    fun nextMonth(view: View?) {
        calendar.nextMonth()
    }

    fun start(view: View?) {
        calendar.toStart()
    }

    fun end(view: View?) {
        calendar.toEnd()
    }

    fun lastYear(view: View?) {
        calendar.lastYear()
    }

    fun nextYear(view: View?) {
        calendar.nextYear()
    }
}