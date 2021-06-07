package com.example.junstagram.data

import com.example.junstagram.model.GallerySelectData

interface LocalDataSource {
    fun getAllGalleryData() : List<GallerySelectData>

    fun insertGalleryImage(gallerySelectData: GallerySelectData)
}