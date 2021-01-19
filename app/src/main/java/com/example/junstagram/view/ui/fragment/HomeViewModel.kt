package com.example.junstagram.view.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.junstagram.model.PhotoPagedList
import com.example.junstagram.repository.Repository
import com.example.junstagram.view.base.BaseViewModel

class HomeViewModel: BaseViewModel() {
    //koin 사용 안하므로 일단 repo 클래스 생성
    private var repository: Repository? = Repository()

    val photoPagedList = liveData<PhotoPagedList> {
        repository?.listData()?.let {
            emit(it)
        }
    }

//    private val _id = MutableLiveData<Long>()
//    //viewmodel에서만 접근.
//    val id: LiveData<Long> = _id
//    //view에서만 observer 가능.


}