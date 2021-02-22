package com.example.junstagram.repository

import com.example.junstagram.R
import com.example.junstagram.data.PhotoDataSource
import com.example.junstagram.data.PhotoRemoteDataSource
import com.example.junstagram.model.PhotoInfo

class PhotoRepositoryImpl(val photoRemoteDataSource: PhotoDataSource = PhotoRemoteDataSource()) : PhotoRepository {
    override suspend fun getPhotoInfoList(page: Int): Pair<List<PhotoInfo>, Int?> {
        return if (page <= 10) Pair(photoRemoteDataSource.getPhotoInfoList(page), page + 1)
        else Pair(listOf(), null)
    }
}