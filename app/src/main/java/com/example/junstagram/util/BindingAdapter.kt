package com.example.junstagram.util

import android.net.Uri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView

@BindingAdapter("bind:photoId")
fun setPhotoId(
    photoView: PhotoView,
    photoId: Int,
){
    Glide.with(photoView.context)
        .load(photoId)
        .into(photoView)
}

@BindingAdapter("bind:gallerySelectedId")
fun setGallerySelectedId(
    photoView: PhotoView,
    galleyId: Uri
){
    Glide.with(photoView.context)
        .load(galleyId)
        .into(photoView)
}