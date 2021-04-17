package com.example.junstagram.util

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Build
import android.widget.Toast
import androidx.core.app.ActivityCompat.requestPermissions
import java.lang.Exception


class PermissionCamera {
    val REQUEST_IMAGE_CAPTURE = 1
    val CAMERA_PERMISSION = arrayOf(Manifest.permission.CAMERA)
    val STORAGE_PERMISSION = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    val FLAG_PERMMISSION_CAMERA = 98
    val FLAG_PERMISSION_STORAGE = 99

//    private fun checkCameraHardware(context: Context) : Boolean {
//        if(context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
//            Toast.makeText(context, "권한 설정 허용", Toast.LENGTH_LONG).show()
//            return true
//        } else {
//            Toast.makeText(context, "권한 설정 실패", Toast.LENGTH_LONG).show()
//            return false
//        }
//    }
//
//    fun getCameraInstance(): Camera? {
//        return try {
//            Camera.open()
//        } catch (e: Exception) {
//            null
//        }
//    }
}