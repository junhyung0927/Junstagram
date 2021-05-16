package com.example.junstagram.view.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.junstagram.R
import com.example.junstagram.databinding.FragmentInsertBinding
import com.example.junstagram.view.base.BaseFragment
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.junstagram.room.AppDatabase
import com.example.junstagram.room.GallerySelectData
import com.example.junstagram.util.GalleryPermission
import org.koin.android.viewmodel.ext.android.viewModel


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

            val gallerySelectData = GallerySelectData(1, "select1", result.data?.data.toString())
            AppDatabase.getInstance(requireContext()).GalleryDao().insertGalleryImage(gallerySelectData)
            binding.textViewSelectText.text = AppDatabase.getInstance(requireContext()).GalleryDao().getAllGalleryData().toString()
        }
}

