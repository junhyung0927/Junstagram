package com.example.junstagram.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.junstagram.model.PhotoPagedList
import java.lang.Exception

class PhotoPagingSource(
    private val repository: PhotoRepository = PhotoRepositoryImpl()
) : PagingSource<Int, PhotoPagedList>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoPagedList> {
        return try {
            //페이지 키 식별값
            val nextPage = params.key ?: 1
            val response = repository.getPagingData(nextPage)

            LoadResult.Page(
                data = response.first,
                prevKey = null,
                nextKey = response.second
            )
        } catch (e: Exception) {
            LoadResult.Error(Throwable("Error"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PhotoPagedList>): Int? {
        TODO("Not yet implemented")
    }


}