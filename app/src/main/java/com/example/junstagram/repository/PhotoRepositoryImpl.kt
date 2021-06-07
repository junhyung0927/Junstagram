package com.example.junstagram.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.junstagram.data.LocalDataSource
import com.example.junstagram.data.PhotoLocalDataSource
import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.model.PhotoInfo

class PhotoRepositoryImpl(
    private val photoPagingSource: PhotoPagingSource,
    private val photoLocalDataSource: LocalDataSource
) : PhotoRepository {
    override suspend fun getPhotoInfoList(): Pager<Int, PhotoInfo> {
        return Pager(PagingConfig(pageSize = 5)) {
            photoPagingSource
        }
    }

    override fun getAllGalleryData(): List<GallerySelectData> {
        return photoLocalDataSource.getAllGalleryData()
    }

    override fun insertGalleryImage(gallerySelectData: GallerySelectData) {
        photoLocalDataSource.insertGalleryImage(gallerySelectData)
    }
}
