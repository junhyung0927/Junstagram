package com.example.junstagram.view.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.junstagram.model.PhotoPagedList
import com.example.junstagram.repository.Repository
import com.example.junstagram.view.base.BaseViewModel

class HomeViewModel: BaseViewModel() {
    private var repository: Repository? = null

    private var _list = MutableLiveData<PhotoPagedList>().apply {
        repository?.listData()
        println(repository?.listData()?.bodyText)
        println(repository?.listData()?.title)
    }

    var test: LiveData<PhotoPagedList> = _list
}