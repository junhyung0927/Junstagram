package com.example.junstagram.view.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.model.PhotoPagedList

class PhotoPagingViewHolder(private var binding: HomeFragmentBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: PhotoPagedList?) {
        binding.headText.text = item?.title
        binding.bodyText.text = item?.title
        binding.photoView.setImageResource(item!!.image)
    }
}