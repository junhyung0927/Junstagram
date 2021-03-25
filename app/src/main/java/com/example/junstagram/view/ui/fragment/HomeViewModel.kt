package com.example.junstagram.view.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.junstagram.repository.PhotoPagingSource
import com.example.junstagram.repository.PhotoRepository
import com.example.junstagram.repository.PhotoRepositoryImpl
import com.example.junstagram.util.Event
import com.example.junstagram.view.base.BaseViewModel

class HomeViewModel(private val photoRepository: PhotoRepository = PhotoRepositoryImpl()) : BaseViewModel() {
    val photoList = Pager(PagingConfig(pageSize = 5)) { //config 설정
            PhotoPagingSource(photoRepository)
        }.flow.cachedIn(viewModelScope)

    private val _onPhotoFocusEvent = MutableLiveData<Event<Int>>()
    val onPhotoFocusEvent: LiveData<Event<Int>>
        get() = _onPhotoFocusEvent

    fun callOnPhotoFocusEvent(photoId: Int) {
        _onPhotoFocusEvent.value = Event(photoId)
    }
}