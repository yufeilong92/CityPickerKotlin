package com.example.myapplication

import android.content.Context

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/6/30 15:24
 * @Purpose :
 */
class a private constructor(){
    companion object {
        @JvmStatic
        fun getInstance(): a {//全局访问点
            return SingletonHolder.mInstance
        }
    }

    private object SingletonHolder {//静态内部类
        val mInstance: a = a()
    }
    private fun readResolve(): Any {//防止单例对象在反序列化时重新生成对象
        return SingletonHolder.mInstance
    }
}