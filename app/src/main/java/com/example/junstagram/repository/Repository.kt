package com.example.junstagram.repository

import com.example.junstagram.R
import com.example.junstagram.model.PhotoPagedList

class Repository {

    fun listData(): PhotoPagedList {
        val list = PhotoPagedList("title", R.drawable.sampleimage13, "bodyText")

        return list
    }
}