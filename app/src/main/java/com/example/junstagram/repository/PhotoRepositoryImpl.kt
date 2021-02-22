package com.example.junstagram.repository

import com.example.junstagram.R
import com.example.junstagram.model.PhotoInfo

class PhotoRepositoryImpl : PhotoRepository {

    override suspend fun listData(): PhotoInfo {
        val list = PhotoInfo("title", R.drawable.sampleimage13, "bodyText")
        return list
    }

    override suspend fun getPagingData(page: Int): Pair<List<PhotoInfo>, Int?> {
        val list = listOf(
            PhotoInfo("title", R.drawable.sampleimage13, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage1, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage12, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage0, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage3, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage4, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage5, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage6, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage7, "bodyText"),
            PhotoInfo("title", R.drawable.sampleimage8, "bodyText"),

        )

        return if (page <= 10) Pair(list, page+1)
        else Pair(listOf(), null)
    }
}