package com.example.junstagram.view.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.junstagram.model.PhotoInfo
import com.example.junstagram.repository.PhotoPagingSource
import com.example.junstagram.repository.PhotoRepository
import com.example.junstagram.repository.PhotoRepositoryImpl
import com.example.junstagram.view.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {
    private var photoRepository: PhotoRepository = PhotoRepositoryImpl()

    //오로지 observing만 하도록 설정
    private val _testId = MutableLiveData<PhotoInfo>()
    val testId: LiveData<PhotoInfo> = _testId

    //필요에 의해서 사용할 수 있음
    init {
    }

    //viewModel scope coroutine
    fun refreshFun() = viewModelScope.launch {
        photoRepository.listData().let {
            //데이터 값 변경
            _testId.value = it
        }
    }

    //앱이 시작할 떄 한번만 호출할 경우
    val photoPagedList = liveData<PhotoInfo> {
        photoRepository.listData().let {
            emit(it)
        }
    }

    val photoList = Pager(PagingConfig(pageSize = 5)) { //config 설정
            PhotoPagingSource(photoRepository)
        }.flow.cachedIn(viewModelScope)
}