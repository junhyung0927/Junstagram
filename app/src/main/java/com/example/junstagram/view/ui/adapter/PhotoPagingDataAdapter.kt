package com.example.junstagram.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.model.PhotoPagedList

class PhotoPagingDataAdapter :
    PagingDataAdapter<PhotoPagedList, PhotoPagingViewHolder>(diffUtil){

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<PhotoPagedList>() {
            override fun areItemsTheSame(oldItem: PhotoPagedList, newItem: PhotoPagedList): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: PhotoPagedList, newItem: PhotoPagedList): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPagingViewHolder {
        return PhotoPagingViewHolder(HomeFragmentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoPagingViewHolder, position: Int) {
        (holder as? PhotoPagingViewHolder)?.bind(item = getItem(position))

//        val photodata = getItem(position)
//        photodata?.let {
//            holder.bind(it)
//        }
    }
}