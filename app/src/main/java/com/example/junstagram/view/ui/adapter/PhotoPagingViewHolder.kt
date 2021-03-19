package com.example.junstagram.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.junstagram.R
import com.example.junstagram.databinding.ItemBinding
import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.util.Event
import com.example.junstagram.view.ui.fragment.HomeViewModel
import android.widget.Toast.makeText as makeText1
import android.widget.Toast.makeText as makeText2

class PhotoPagingViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.photofocus = this
        onPhotoFocusListener()
    }

    fun bind(item: PhotoInfo) {
        Glide.with(binding.root)
            .load(item.image)
            .into(binding.photoView)

        binding.headText.text = item.title
        binding.bodyText.text = item.bodyText
    }

    fun onPhotoFocusListener() {
        println("test")
    }
}