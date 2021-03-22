package com.example.junstagram.view.ui.adapter

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.junstagram.databinding.ItemBinding
import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.util.Event

class PhotoPagingViewHolder(val binding: ItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.photofocus = this
    }

    fun bind(item: PhotoInfo) {
        Glide.with(binding.root)
            .load(item.image)
            .into(binding.photoView)
        binding.headText.text = item.title
        binding.bodyText.text = item.bodyText
    }

    fun onPhotoFocusListener(customDialog: (CustomDialog) -> Unit){
        val dialog = CustomDialog()
        customDialog(dialog)
    }
}