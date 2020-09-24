package com.example.myapplication

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main9.*

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        bindViewData()
    }
    private fun bindViewData() {
        val list = mutableListOf<String>()
        for (item in 0..200) {
            list.add("$item")
        }
        val adapter = TestAdapter(this,list)
        val mll= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rlv_main6_content.layoutManager=mll
        rlv_main6_content.adapter=adapter
      adapter.addChildClickViewIds(R.id.tv_text_content,R.id.et_text_content,R.id.tv_text_contentone,R.id.tv_text_contenttwo)
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when(view.id){
                R.id.et_text_content->{
                    Toast.makeText(this, "$position et_text_content", Toast.LENGTH_SHORT).show();
                }
                R.id.tv_text_content->{

                    Toast.makeText(this, "$position tv_text_content", Toast.LENGTH_SHORT).show();
                }
                R.id.tv_text_contentone->{
                    Toast.makeText(this, "$position tv_text_contentone", Toast.LENGTH_SHORT).show();
                }
                R.id.tv_text_contenttwo->{
                    Toast.makeText(this, "$position tv_text_contenttwo", Toast.LENGTH_SHORT).show();
                }
            }
        }

/*        val end = tv_main_6.paint.textSize*tv_main_6.text.length
        val colors= intArrayOf(Color.RED,Color.GREEN,Color.BLUE)
        val postion= floatArrayOf(0f,0.5f,1.0f)

        val linear=LinearGradient(0f,0f,end,0f,colors,postion,Shader.TileMode.CLAMP)
        tv_main_6.paint.shader=linear
        tv_main_6.invalidate()*/
    }
}