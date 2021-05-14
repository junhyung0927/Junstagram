package com.example.junstagram.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.junstagram.R
import com.example.junstagram.databinding.FragmentInsertBinding
import com.example.junstagram.view.base.BaseFragment
import com.gun0912.tedpermission.TedPermission
import com.gun0912.tedpermission.PermissionListener
import android.Manifest
import org.koin.android.ext.android.bind

class InsertFragment : BaseFragment<FragmentInsertBinding>(R.layout.fragment_insert) {
    companion object {
        fun newInstance() = InsertFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        galleryPermission()

        binding.lifecycleOwner = this

        binding.apply {

        }
    }

    private fun galleryPermission() {
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