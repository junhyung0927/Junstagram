package com.example.junstagram.util

import android.Manifest
import android.content.Context
import android.content.Intent
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission


class GalleryPermission() {
    fun galleryPermission(context: Context?) {
        TedPermission.with(context)
            .setPermissionListener(object : PermissionListener {
                override fun onPermissionGranted() {
                    println("권한 허용 가능")
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    for (i in deniedPermissions!!)
                        println("권한 허용 불가능")
                }
            })
            .setDeniedMessage("앱을 실행하려면 권한을 허용해야 합니다.")
            .setPermissions(Manifest.permission.CAMERA)
            .check()
    }

}
