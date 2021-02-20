package com.example.junstagram.view.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.databinding.ItemBinding
import com.example.junstagram.model.PhotoPagedList

class PhotoPagingViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: PhotoPagedList?) {

        binding.headText.text = item?.title
        binding.bodyText.text = item?.bodyText
        binding.photoView.setImageResource(item!!.image)
    }
}