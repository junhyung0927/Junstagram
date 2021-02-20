package com.example.junstagram.repository

import com.example.junstagram.R
import com.example.junstagram.model.PhotoPagedList

class PhotoRepositoryImpl : PhotoRepository {

    override suspend fun listData(): PhotoPagedList {
        val list = PhotoPagedList("title", R.drawable.sampleimage13, "bodyText")
        return list
    }

    override suspend fun getPagingData(page: Int): Pair<List<PhotoPagedList>, Int?> {
        val list = listOf(
            PhotoPagedList("title", R.drawable.sampleimage13, "bodyText"),
        )

        return if (page <= 10) Pair(list, page+1)
        else Pair(listOf(), null)
    }
}