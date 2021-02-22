package com.example.junstagram.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.junstagram.databinding.ItemBinding
import com.example.junstagram.model.PhotoInfo

class PhotoPagingDataAdapter :
    PagingDataAdapter<PhotoInfo, PhotoPagingViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPagingViewHolder {
        return PhotoPagingViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                null,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoPagingViewHolder, position: Int) {
        val photodata = getItem(position)

        photodata?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PhotoInfo>() {

            override fun areItemsTheSame(
                oldItem: PhotoInfo,
                newItem: PhotoInfo
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PhotoInfo,
                newItem: PhotoInfo
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}
