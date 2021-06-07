package com.example.junstagram.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.junstagram.databinding.UserItemBinding
import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.view.ui.fragment.HomeFragment
import com.example.junstagram.view.ui.fragment.HomeViewModel

class PhotoPagingDataAdapter(val homeViewModel: HomeViewModel) :
    PagingDataAdapter<PhotoInfo, PhotoPagingDataAdapter.PhotoPagingViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPagingViewHolder {
        return PhotoPagingViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context), null, false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoPagingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class PhotoPagingViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.photoViewItemImage.setOnClickListener {
                getItem(bindingAdapterPosition)?.let {
                    homeViewModel.callOnPhotoFocusEvent(it.image)
                }
            }
        }

        fun bind(item: PhotoInfo) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PhotoInfo>() {
            override fun areItemsTheSame(
                oldItem: PhotoInfo, newItem: PhotoInfo
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PhotoInfo, newItem: PhotoInfo
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}
