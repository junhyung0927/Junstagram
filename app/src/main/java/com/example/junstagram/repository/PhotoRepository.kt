package com.example.junstagram.repository

import com.example.junstagram.R
import com.example.junstagram.model.PhotoPagedList

interface PhotoRepository {
    suspend fun listData(): PhotoPagedList
}