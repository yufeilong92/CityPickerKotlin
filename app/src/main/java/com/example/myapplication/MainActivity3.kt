package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main6.*
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        initListener()
        val open = resources.assets.open("phone.txt")
        val list = mutableListOf<String>()
        val lists = mutableListOf<String>()
        BufferedReader(InputStreamReader(open)).use {
            var line: String
            while (true) {
                line = it.readLine() ?: break
                list.add(line)
            }
        }
        val open2 = resources.assets.open("phone2.txt")
        BufferedReader(InputStreamReader(open2)).use {
            var line: String
            while (true) {
                line = it.readLine() ?: break
                lists.add(line)
            }
        }
        list.removeAll(lists)
        val sb = StringBuffer()
        for (child in list) {
            sb.append("$child")
            sb.append("\r\n")
        }
//        saveLog(this, sb.toString())

        btn_eight.setOnClickListener {


        }

    }

    private fun initListener() {
        btn_one.setOnClickListener {
            save("22222222")
        }
        btn_two.setOnClickListener {
            val load = load()
            Toast.makeText(this, "$load", Toast.LENGTH_SHORT).show()
        }
        btn_three.setOnClickListener {
            val file=File(externalCacheDir,"${System.currentTimeMillis()}.jpg")
            if (file.exists())
                file.delete()
            file.createNewFile()
            val imagerUri=if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                FileProvider.getUriForFile(this,"com.example.myapplication.fileprovider",file)
            }else{
                Uri.fromFile(file)
            }
            val intent= Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imagerUri)
            startActivityForResult(intent,1)
        }
    }

    fun saveLog(con: Context, com: String) {

        val path = "${con.externalCacheDir}/手机号.txt"
        val file = File(path)
        var raf: RandomAccessFile?
        try {
            raf = RandomAccessFile(file, "rw")
            raf.seek(file.length())
            raf.write(com.toByteArray())
            raf.close()

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun save(str: String) {
        try {
            val output = openFileOutput("data", Context.MODE_APPEND)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(str)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun load():String{
        val com=StringBuilder()
        try {
            val input=openFileInput("data")
            val reader=BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    com.append(it)
                }
            }

        }catch (e :Exception){
            e.printStackTrace()
        }
        return com.toString()
    }
}