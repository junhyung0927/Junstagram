package com.example.junstagram.view.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junstagram.R
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.util.EventObserver
import com.example.junstagram.view.base.BaseFragment
import com.example.junstagram.view.ui.adapter.CustomDialog
import com.example.junstagram.view.ui.adapter.PhotoFocusListener
import com.example.junstagram.view.ui.adapter.PhotoPagingDataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.apply {
            val photoPagingDataAdapter = PhotoPagingDataAdapter(listener = null)

            recyclerViewHomeFragment.apply {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = PhotoPagingDataAdapter(object : PhotoFocusListener {
                    override fun onPhotoFocus(callback: CustomDialog) {
                        callback.showsDialog
                    }
                })
            }

            lifecycleScope.launch {
                homeViewModel.photoList.collectLatest { pagingData ->
                    photoPagingDataAdapter.submitData(pagingData)
                }
            }
        }
    }
}