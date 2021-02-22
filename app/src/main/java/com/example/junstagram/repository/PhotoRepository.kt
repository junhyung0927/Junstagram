package com.example.junstagram.repository

import com.example.junstagram.model.PhotoInfo

interface PhotoRepository {
    suspend fun listData(): PhotoInfo

    suspend fun getPagingData(page: Int) : Pair<List<PhotoInfo>, Int?>
}