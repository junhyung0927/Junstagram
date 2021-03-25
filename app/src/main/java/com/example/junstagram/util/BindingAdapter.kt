package com.example.junstagram.util

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