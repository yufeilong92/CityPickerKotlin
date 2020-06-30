package com.example.myapplication

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.guolindev.PermissionX

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        PermissionX.init(this)
            .permissions(Manifest.permission.READ_CONTACTS,Manifest.permission.CAMERA,Manifest.permission.CALL_PHONE)
            .explainReasonBeforeRequest()
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(deniedList, "Core fundamental are based on these permissions", "OK", "Cancel")
            }
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(deniedList,"You need to allow necessary permissions in Settings manually", "OK", "Cancel")
            }
            .request{allGranted, grantedList, deniedList ->
                if (allGranted){
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "These permissions are denied: $deniedList", Toast.LENGTH_LONG).show()
                }
            }
    }
}
