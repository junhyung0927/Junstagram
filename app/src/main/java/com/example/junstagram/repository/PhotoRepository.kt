package com.example.junstagram.repository

import com.example.junstagram.model.PhotoInfo

interface PhotoRepository {
    suspend fun getPhotoInfoList(page: Int) : Pair<List<PhotoInfo>, Int?>
}