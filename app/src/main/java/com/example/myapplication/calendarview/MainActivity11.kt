package com.example.myapplication.calendarview

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main11.*
import java.util.*

/**
 * @Author : YFL  is Creating a porject in del
 * @Package :
 * @Email : yufeilong92@163.com
 * @Time :2020/8/27 13:33
 * @Purpose :
 */
class MainActivity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        initEvent()
        initListener()
        initViewModel()
    }

    private fun initEvent() {
        val sb = StringBuilder()
        val list: MutableList<String> =
            ArrayList()
        list.add("2017.11.11")
        list.add("2017.11.12")
        list.add("2017.12.22")
        list.add("2017.12.25")
        calendar11.setStartEndDate("2017.1", "2019.12")
            .setDisableStartEndDate("2017.10.7", "2019.10.7")
            .setInitDate("2017.11")
            .setMultiDate(list)
            .init();
        tv_title11.text = 2017.toString() + "年" + 11 + "月"
        for (d in list) {
            sb.append("选中：$d\n")
        }
        choose_date11.text = sb.toString()
        calendar11.setOnMultiChooseListener { view, date, flag ->
            val d = date.solar[0].toString() + "." + date.solar[1] + "." + date.solar[2] + "."
            if (flag) { //选中
                sb.append("选中：$d\n")
            } else { //取消选中
                sb.append("取消：$d\n")
            }
            choose_date11.setText(sb.toString())
            //test

            //test
            if (flag) {
                for (db in calendar11.getMultiDate()) {
                    Log.e(
                        "date:",
                        "" + db.solar[0] + db.solar[1] + db.solar[2]
                    )
                }
            }
        }
        calendar11.setOnPagerChangeListener { date ->
            tv_title11.text = date.get(0).toString() + "年" + date.get(1) + "月"
        }


    }

    fun lastMonth(view: View?) {
        calendar11.lastMonth()
    }

    fun nextMonth(view: View?) {
        calendar11.nextMonth()
    }
    private fun initListener() {

    }

    private fun initViewModel() {

    }
}