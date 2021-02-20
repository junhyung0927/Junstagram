package com.example.junstagram.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.junstagram.R
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.databinding.ItemBinding
import com.example.junstagram.model.PhotoPagedList

class PhotoPagingDataAdapter :
    PagingDataAdapter<PhotoPagedList, PhotoPagingViewHolder>(diffUtil) {

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
        val diffUtil = object : DiffUtil.ItemCallback<PhotoPagedList>() {

            override fun areItemsTheSame(
                oldItem: PhotoPagedList,
                newItem: PhotoPagedList
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PhotoPagedList,
                newItem: PhotoPagedList
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}
