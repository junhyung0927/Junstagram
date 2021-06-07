
package com.example.junstagram.view.ui.fragment

import androidx.lifecycle.*
import androidx.paging.*
import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.repository.PhotoRepository
import com.example.junstagram.util.Event
import com.example.junstagram.view.base.BaseViewModel

class HomeViewModel(private val photoRepository: PhotoRepository) : BaseViewModel() {
    val photoList = liveData<PagingData<PhotoInfo>> { //liveData
        emitSource(photoRepository.getPhotoInfoList().liveData)
    }

    private val _onPhotoFocusEvent = MutableLiveData<Event<Int>>()
    val onPhotoFocusEvent: LiveData<Event<Int>>
        get() = _onPhotoFocusEvent

    fun callOnPhotoFocusEvent(photoId: Int) {
        _onPhotoFocusEvent.value = Event(photoId)
    }
}