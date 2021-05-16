package com.example.junstagram.data

import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.room.GalleryDao

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