package com.example.junstagram.model

import android.net.Uri
import android.provider.ContactsContract
import com.github.chrisbanes.photoview.PhotoView

data class GalleryData(
    val imageName : String,
    val uri : Uri
)

