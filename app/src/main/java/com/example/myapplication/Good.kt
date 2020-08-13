package com.example.myapplication

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/7/23 9:11
 * @Purpose :
 */
data class Good(
    val pName: String = "",
    val pId: Int = 0,
    val childs: MutableList<ChildGood>? = null
)

data class ChildGood(
    val name: String = "",
    val id: Int = 0
)