package com.example.junstagram.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.model.PhotoPagedList

class PhotoPagingDataAdapter(diffUtil: DiffUtil.ItemCallback<PhotoPagedList>) :
    PagingDataAdapter<PhotoPagedList, PhotoPagingViewHolder>(diffUtil){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPagingViewHolder {
        return PhotoPagingViewHolder(HomeFragmentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoPagingViewHolder, position: Int) {
        val photodata = getItem(position)

        photodata?.let {
            holder.bind(it)
        }
    }
}