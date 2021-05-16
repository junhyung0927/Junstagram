package com.example.junstagram.repository

import androidx.paging.Pager
import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.model.PhotoInfo

interface PhotoRepository {
    suspend fun getPhotoInfoList() : Pager<Int, PhotoInfo>

    fun getAllGalleryData() : List<GallerySelectData>

    fun insertGalleryImage(gallerySelectData: GallerySelectData)
}