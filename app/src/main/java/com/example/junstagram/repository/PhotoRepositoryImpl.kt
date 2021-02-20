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
            PhotoPagedList("title", R.drawable.sampleimage1, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage12, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage0, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage3, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage4, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage5, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage6, "bodyText"),
            PhotoPagedList("title", R.drawable.sampleimage7, "bodyText"),

        )

        return if (page <= 10) Pair(list, page+1)
        else Pair(listOf(), null)
    }
}