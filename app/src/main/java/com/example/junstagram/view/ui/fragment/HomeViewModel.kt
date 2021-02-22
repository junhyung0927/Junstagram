package com.example.junstagram.view.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.repository.PhotoPagingSource
import com.example.junstagram.repository.PhotoRepository
import com.example.junstagram.repository.PhotoRepositoryImpl
import com.example.junstagram.view.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(private val photoRepository: PhotoRepository = PhotoRepositoryImpl()) : BaseViewModel() {
    val photoList = Pager(PagingConfig(pageSize = 1)) { //config 설정
            PhotoPagingSource(photoRepository)
        }.flow.cachedIn(viewModelScope)
}