package com.example.junstagram.model

import android.net.Uri
import android.provider.ContactsContract
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.chrisbanes.photoview.PhotoView

@Entity
data class GallerySelectData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var imageName: String ?= null,
    var uri: Uri? = null
)

