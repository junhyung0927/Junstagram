package com.example.junstagram.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.junstagram.model.PhotoInfo

class PhotoRepositoryImpl(
    val photoPagingSource: PhotoPagingSource
) : PhotoRepository {
    override suspend fun getPhotoInfoList(): Pager<Int, PhotoInfo> {
        return Pager(PagingConfig(pageSize = 5)) {
            photoPagingSource
        }
    }
}