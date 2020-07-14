package com.example.myapplication

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.permissionx.guolindev.PermissionX
import kotlinx.android.synthetic.main.activity_main5.*

/**
 * @Author : YFL  is Creating a porject in del
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/7/14 9:18
 * @Purpose :查看数据
 */
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        PermissionX.init(this)
            .permissions(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS
            )
            .explainReasonBeforeRequest()
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(
                    deniedList,
                    "Core fundamental are based on these permissions",
                    "OK",
                    "Cancel"
                )
            }
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(
                    deniedList,
                    "You need to allow necessary permissions in Settings manually",
                    "OK",
                    "Cancel"
                )
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                    bindViewData()
                } else {
                    Toast.makeText(
                        this,
                        "These permissions are denied: $deniedList",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }


    }

    private fun bindViewData() {
        val list = mutableListOf<String>()
        contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )?.apply {
            while (moveToNext()) {
                val name =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phoneAdapter =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                list.add("$name$phoneAdapter")
            }
            val adpater = PhoneAdapter(this@MainActivity2, list)
            val gl = GridLayoutManager(this@MainActivity2, 1)
            rlv_main_2.layoutManager = gl
            rlv_main_2.adapter = adpater
            close()
        }
    }
}