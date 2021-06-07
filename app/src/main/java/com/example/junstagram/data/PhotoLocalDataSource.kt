package com.example.junstagram.data

import android.net.Uri
import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.room.AppDatabase
import com.example.junstagram.room.GalleryDao
import org.koin.android.ext.android.inject

class PhotoLocalDataSource(
    private val galleryDao: GalleryDao
    ) : LocalDataSource {
    override fun getAllGalleryData(): List<GallerySelectData> {
        return galleryDao.getAllGalleryData()
    }

    override fun insertGalleryImage(gallerySelectData: GallerySelectData) {
        galleryDao.insertGalleryImage(gallerySelectData)
    }
}