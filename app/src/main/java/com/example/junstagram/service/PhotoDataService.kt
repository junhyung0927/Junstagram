package com.example.junstagram.service

import com.example.junstagram.model.PhotoInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoDataService {
    @GET("wisoft/jun/{id}")
    suspend fun getPhotoInfoList(@Path("id") page: Int?) : List<PhotoInfo>
}