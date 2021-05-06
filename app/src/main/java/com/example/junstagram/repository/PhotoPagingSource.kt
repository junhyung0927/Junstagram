package com.example.junstagram.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.junstagram.data.PhotoDataSource
import com.example.junstagram.model.PhotoInfo
import java.lang.Exception

class PhotoPagingSource(
    private val photoDataSource: PhotoDataSource
) : PagingSource<Int, PhotoInfo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoInfo> {
        return try {
            //페이지 키 식별값
            val nextPage = params.key ?: 1
            val response =
                if (nextPage <= 10) {
                    Pair(photoDataSource.getPhotoInfoList(nextPage), nextPage + 1)
                } else {
                    Pair(listOf(), null)
                }

            LoadResult.Page(
                data = response.first,
                prevKey = null,
                nextKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(Throwable("Error"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PhotoInfo>): Int? {
        TODO("Not yet implemented")
    }
}