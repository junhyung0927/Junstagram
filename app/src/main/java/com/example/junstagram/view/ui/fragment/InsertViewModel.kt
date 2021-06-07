package com.example.junstagram.view.ui.fragment

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.junstagram.model.GallerySelectData
import com.example.junstagram.repository.PhotoRepository
import com.example.junstagram.room.GalleryDao
import com.example.junstagram.util.Event
import org.koin.android.ext.android.inject
import com.example.junstagram.view.base.BaseViewModel

class InsertViewModel(
    private val photoRepository: PhotoRepository
) : BaseViewModel() {
    fun getAllGalleryData(): List<GallerySelectData> {
        return photoRepository.getAllGalleryData()
    }

    fun insertGalleryImage(gallerySelectData: GallerySelectData) {
        photoRepository.insertGalleryImage(gallerySelectData)
    }

    private val _onGallerySelectedEvent = MutableLiveData<Event<Uri>>()
    val onGallerySelectedEvent: LiveData<Event<Uri>>
        get() = _onGallerySelectedEvent

    fun callOnGallerySelectedEvent(selectedUri: Uri) {
        _onGallerySelectedEvent.value = Event(selectedUri)
    }
}