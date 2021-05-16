package com.example.junstagram.view.ui.fragment

import android.content.Intent
import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.repository.PhotoRepository

import com.example.junstagram.view.base.BaseViewModel

class InsertViewModel(
    private val photoRepository: PhotoRepository
) : BaseViewModel() {
    fun getAllGalleryData(): List<GallerySelectData> {
        return photoRepository.getAllGalleryData()
    }

    fun insertGalleryImage(gallerySelectData: GallerySelectData) {
        photoRepository.insertGalleryImage(gallerySelectData)
    }
}