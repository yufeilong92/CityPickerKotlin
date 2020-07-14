package com.example.myapplication

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.permissionx.guolindev.PermissionX
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
        private const val PERMISSION_CODE = 999
        private const val CREATE_DOCUMENT = 2000
        private const val PICK_DOCUMENT = 1000
        private const val PICK_DIR = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        initlIST()
        PermissionX.init(this)
            .permissions(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.CAMERA,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
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
                } else {
                    Toast.makeText(
                        this,
                        "These permissions are denied: $deniedList",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        btn_one.setOnClickListener {
            createText()
        }
        btn_two.setOnClickListener {
            textTwo()
        }
    }

    private fun textTwo(){
        val dowm = getExternalFilesDir(Intent.ACTION_OPEN_DOCUMENT)

    }

    private fun initlIST() {
        swr_layout.setOnRefreshListener {

        }
        val adapter = MainAdapter(this, getdata())
        val lm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val d=GridSpaceItemDecoration(2,10,true)
        rlv_content.layoutManager = lm
        rlv_content.addItemDecoration(d)
        rlv_content.adapter = adapter
    }

    private fun getdata(): MutableList<String> {
        val list = mutableListOf<String>()
        for (int in 0 until 30)
            list.add("$int")
        return list
    }

    fun createText() {
        MyDownloadCollection().createDocument(this, "text/panin", "text.text", CREATE_DOCUMENT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        if (requestCode == CREATE_DOCUMENT && resultCode == Activity.RESULT_OK) {
            data?.data?.also {
                Log.d("===", "uri=$it")
                writeDocument(it)
            }
        }
    }

    /**
     * 写入数据到文档
     */
    private fun writeDocument(uri: Uri) {
        MyDownloadCollection().writeDataToDocument(
            this,
            uri,
            "balabalabalabalabalabalabalabalabalabalabalabala"
        )
    }

}
