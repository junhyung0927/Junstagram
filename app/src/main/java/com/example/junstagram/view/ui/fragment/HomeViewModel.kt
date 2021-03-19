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
import com.example.junstagram.util.Event
import com.example.junstagram.view.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(private val photoRepository: PhotoRepository = PhotoRepositoryImpl()) : BaseViewModel() {
    val photoList = Pager(PagingConfig(pageSize = 5)) { //config 설정
            PhotoPagingSource(photoRepository)
        }.flow.cachedIn(viewModelScope)

    private val _callEvent = MutableLiveData<Event<Boolean>>()
    val callEvent: LiveData<Event<Boolean>>
        get() = _callEvent

    fun onPhotoFocusListener() {
        _callEvent.value = Event(true)
    }
}