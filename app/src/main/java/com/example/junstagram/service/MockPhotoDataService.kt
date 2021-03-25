package com.example.junstagram.service

import com.example.junstagram.R
import com.example.junstagram.model.PhotoInfo

class MockPhotoDataService : PhotoDataService{
    override suspend fun getPhotoInfoList(page: Int?): List<PhotoInfo> {
        val list = listOf(
            PhotoInfo("care_all_j", R.drawable.sampleimage13, "안녕하세요"),
            PhotoInfo("kangsam", R.drawable.sampleimage1, "bodyText"),
            PhotoInfo("insite", R.drawable.sampleimage12, "bodyText"),
            PhotoInfo("nike", R.drawable.sampleimage0, "bodyText"),
            PhotoInfo("musinsa", R.drawable.sampleimage3, "bodyText"),
            PhotoInfo("etcSeoul", R.drawable.sampleimage4, "bodyText"),
            PhotoInfo("Lotte", R.drawable.sampleimage5, "bodyText"),
            PhotoInfo("Samsung", R.drawable.sampleimage6, "bodyText"),
            PhotoInfo("bigNurd", R.drawable.sampleimage7, "bodyText"),
            PhotoInfo("apple", R.drawable.sampleimage8, "bodyText")
        )

        return list
    }
}