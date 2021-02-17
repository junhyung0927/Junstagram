package com.example.junstagram.view.ui.adapter

import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.junstagram.model.PhotoPagedList

class PhotoPagingDataAdapter(diffUtil: DiffUtil.ItemCallback<PhotoPagedList>) :
    PagingDataAdapter<PhotoPagedList, PhotoPagingViewHolder>(diffUtil){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPagingViewHolder {
        return 
    }

    override fun onBindViewHolder(holder: PhotoPagingViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}