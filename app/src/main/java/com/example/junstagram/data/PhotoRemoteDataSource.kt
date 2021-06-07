package com.example.junstagram.data

import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.service.PhotoDataService


class PhotoRemoteDataSource(
    private val photoDataService: PhotoDataService
) : PhotoDataSource {
    override suspend fun getPhotoInfoList(page: Int): List<PhotoInfo> {
        return photoDataService.getPhotoInfoList(page)
    }
}
