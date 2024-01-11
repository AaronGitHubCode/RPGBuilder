package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import android.content.pm.PackageManager.PERMISSION_DENIED

import android.Manifest.permission.POST_NOTIFICATIONS

import android.content.Intent

import android.os.Build
import android.os.Bundle

import android.view.Menu

import android.widget.TextView

import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

import androidx.annotation.RequiresApi

import androidx.appcompat.app.AppCompatActivity

private const val REQUEST_CODE = 101

class MainActivity : AppCompatActivity(R.layout.main_layout) {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        if (checkSelfPermission(POST_NOTIFICATIONS) == PERMISSION_DENIED)
            requestPermissions(arrayOf(POST_NOTIFICATIONS), REQUEST_CODE)
    }

    override fun onStart(): Unit {
        super.onStart()

        findViewById<TextView>(R.id.start).setOnClickListener {
            it as TextView

            registerForActivityResult(StartActivityForResult()) {}
                .launch(Intent(this, OptionsActivity::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ): Unit {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE) {
            if (grantResults.contains(PERMISSION_DENIED)) {
                finish()
            }
        }
    }
}