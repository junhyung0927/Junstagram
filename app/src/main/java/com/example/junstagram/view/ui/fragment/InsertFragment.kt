package com.example.junstagram.view.ui.fragment

import android.app.ActionBar
import android.os.Bundle
import android.view.View
import com.example.junstagram.R
import com.example.junstagram.databinding.FragmentInsertBinding
import com.example.junstagram.view.base.BaseFragment
import android.content.Intent
import android.view.ViewTreeObserver
import android.view.Window
import android.view.WindowManager
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase
import com.example.junstagram.di.roomModule
import com.example.junstagram.room.AppDatabase
import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.room.GalleryDao
import com.example.junstagram.util.EventObserver
import com.example.junstagram.util.GalleryPermission
import com.example.junstagram.view.ui.adapter.GalleryAdapter
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.androidx.scope.fragmentScope
import com.example.junstagram.util.whenReadyDraw as WhenReadyDraw

class InsertFragment : BaseFragment<FragmentInsertBinding>(R.layout.fragment_insert) {
    private val insertViewModel: InsertViewModel by viewModel()
    private val room: GalleryDao by inject()
    private var lastClickedPosition = 0

    companion object {
        fun newInstance() = InsertFragment()
        const val KEY_GALLERY_ID_SELECT_IMAGE: String = Intent.EXTRA_MIME_TYPES
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.apply {
            GalleryPermission().requestPermission(context) {
                val galleryAdapter = GalleryAdapter(requireContext(), insertViewModel, lastClickedPosition)
                recyclerViewInsertFragment.apply {
                    layoutManager = GridLayoutManager(requireContext(), 3)
                    setHasFixedSize(true)
                    adapter = galleryAdapter
                }
            }
        }

        insertViewModel.apply {
            onGallerySelectedEvent.observe(viewLifecycleOwner, EventObserver {
                binding.photoViewPreviewImageInsertFragment.setImageURI(it)
                val selectedUri = it
                binding.buttonAddTextInsertFragment.setOnClickListener {
                    val gallerySelectData = GallerySelectData(1,  selectedUri)
                    insertGalleryImage(gallerySelectData)
                }
            })
        }
    }
}

