package com.example.junstagram.data

import com.example.junstagram.model.PhotoInfo

interface PhotoDataSource {
    suspend fun getPhotoInfoList(page: Int) : List<PhotoInfo>
}