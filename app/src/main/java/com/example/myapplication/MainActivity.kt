package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zaaach.citypicker.CityPicker
import com.zaaach.citypicker.adapter.OnPickListener
import com.zaaach.citypicker.model.City
import com.zaaach.citypicker.model.HotCity
import com.zaaach.citypicker.model.LocateState
import com.zaaach.citypicker.model.LocatedCity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val KEY = "current_theme"
    private var hotCities: MutableList<HotCity>? = null
    private var anim = 0
    private var mTheme = 0
    private var enable = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            mTheme = savedInstanceState.getInt(KEY)
            setTheme(if (mTheme > 0) mTheme else R.style.DefaultCityPickerTheme)
        }
        setContentView(R.layout.activity_main)
        if (mTheme == R.style.DefaultCityPickerTheme) {
            btn_style.text = "默认主题";
        } else if (mTheme == R.style.CustomTheme) {
            btn_style.text = "自定义主题";
        }
        btn_style.setOnClickListener {
            val com = btn_style.text
            if (com.startsWith("自定义")) {
                btn_style.text = "默认主题"
                mTheme = R.style.DefaultCityPickerTheme
            } else if (com.startsWith("默认")) {
                btn_style.text = "自定义主题"
                mTheme = R.style.CustomTheme
            }
            recreate();
        }
        btn_pick.setOnClickListener {
            CityPicker.from(this@MainActivity)
                .enableAnimation(enable)
                .setAnimationStyle(anim)
                .setLocatedCity(null)
                .setHotCities(hotCities)
                .setOnPickListener(object : OnPickListener {
                    override fun onPick(position: Int, data: City) {
                        tv_current.setText(
                            String.format(
                                "当前城市：%s，%s",
                                data.name,
                                data.code
                            )
                        )
                        Toast.makeText(
                            applicationContext,
                            String.format("点击的数据：%s，%s", data.name, data.code),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    override fun onCancel() {
                        Toast.makeText(applicationContext, "取消选择", Toast.LENGTH_SHORT).show()
                    }

                    override fun onLocate() {
                        //开始定位，这里模拟一下定位
                        Handler().postDelayed(Runnable {
                            CityPicker.from(this@MainActivity).locateComplete(
                                LocatedCity("深圳", "广东", "101280601"),
                                LocateState.SUCCESS
                            )
                        }, 3000)
                    }
                })
                .show()
        }
        cb_hot.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                hotCities = mutableListOf()
                hotCities?.add(HotCity("北京", "北京", "101010100"))
                hotCities?.add(HotCity("上海", "上海", "101020100"))
                hotCities?.add(HotCity("广州", "广东", "101280101"))
                hotCities?.add(HotCity("深圳", "广东", "101280601"))
                hotCities?.add(HotCity("杭州", "浙江", "101210101"))
            } else
                hotCities = mutableListOf()
        }
        cb_anim.setOnCheckedChangeListener { compoundButton, b ->
            anim=if (b) R.style.CustomAnim else R.style.DefaultCityPickerTheme
        }
        cb_enable_anim.setOnCheckedChangeListener { compoundButton, b ->
            enable=b
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY,mTheme)
    }
}
