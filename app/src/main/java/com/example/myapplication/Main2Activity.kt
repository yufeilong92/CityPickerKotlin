package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.io.*
import java.lang.Exception
import kotlin.math.log

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val getInstance = GMhELP.get_Instance(this)
        getInstance!!.delete()
        val open = assets.open("b.txt")
        //把文件内容读取进缓冲读取器（use方法会自动对BufferedReader进行关闭）
        val list = mutableListOf<String>()
        BufferedReader(InputStreamReader(open)).use {
            var line: String
            while (true) {
                line = it.readLine() ?: break //当有内容时读取一行数据，否则退出循环
                list.add(line)
                println(line) //打印一行数据 } }
            }
        }
        val newList = mutableListOf<String>()
        for (item in 0 until list.size) {
            val split = list[item].split("(")
            if (split.size < 2) {
                Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show();
                continue
            } else {
                val before = split[0]
                val after = split[1]
                val split1 = after.split(",")
                val id = split1[0]
                val priceve = split1[3]
                val sb = StringBuffer()
                sb.append(before)
                for (index in 0 until split1.size) {
                    if (index == 0) {
                        sb.append("(${split1[index]},")
                    } else if (index == split1.size - 1) {
                        sb.append("$priceve);")
                    } else if (index == split1.size - 2){
                        sb.append("$id")
                        sb.append(",")
                    } else {
                        sb.append(split1[index])
                        sb.append(",")
                    }
                }
                getInstance!!.addExaSql(sb.toString())
                newList.add("$sb")
            }
        }
        saveLog(this, newList.toString())

    }

    fun saveLog(con: Context, com: String) {

        val path = "${con.externalCacheDir}/log.txt"
        val file1 = File(path)
        file1.delete()
        val file = File(path)
        var raf: RandomAccessFile? = null
        try {
            raf = RandomAccessFile(file, "rw")
            raf.seek(file.length())
            raf.write(com.toByteArray())
            raf.close()

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

}

