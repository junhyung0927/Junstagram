package com.example.junstagram.view.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.example.junstagram.R
import com.example.junstagram.databinding.FragmentInsertBinding
import com.example.junstagram.view.base.BaseFragment
import android.content.Intent
import android.net.Uri
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.junstagram.util.GalleryPermission
import gun0912.tedimagepicker.builder.TedImagePicker
import org.koin.android.viewmodel.ext.android.viewModel
import java.net.URI


class InsertFragment : BaseFragment<FragmentInsertBinding>(R.layout.fragment_insert) {
    private val insertViewModel: InsertViewModel by viewModel()

    companion object {
        fun newInstance() = InsertFragment()
        const val KEY_GALLERY_ID_SELECT_IMAGE: String = Intent.EXTRA_MIME_TYPES
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        binding.apply {
            GalleryPermission().galleryPermission(context)
            pickFromGallery()
        }
    }

    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setType("image/*")
        val mimTypes = arrayOf(
            "image/jpeg", "image/png"
        )
        intent.putExtra(KEY_GALLERY_ID_SELECT_IMAGE, mimTypes)
        startForResult.launch(intent)
    }

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            binding.photoViewInsertImage.setImageURI(result.data?.data)
        }
}