package com.example.junstagram.service

import com.example.junstagram.R
import com.example.junstagram.model.PhotoInfo

class MockPhotoDataService : PhotoDataService{
    override suspend fun getPhotoInfoList(page: Int?): List<PhotoInfo> {
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
            PhotoInfo("title", R.drawable.sampleimage8, "bodyText")
        )

        return list
    }
}