package com.example.junstagram.data

import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.service.MockPhotoDataService


class PhotoRemoteDataSource(val mockData: MockPhotoDataService = MockPhotoDataService()) : PhotoDataSource {
    override suspend fun getPhotoInfoList(page: Int): List<PhotoInfo> {
        return mockData.getPhotoInfoList(page)
    }
}