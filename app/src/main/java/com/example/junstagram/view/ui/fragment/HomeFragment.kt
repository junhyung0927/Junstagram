package com.example.junstagram.view.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junstagram.R
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.util.EventObserver
import com.example.junstagram.view.base.BaseFragment
import com.example.junstagram.view.ui.adapter.ImageFocusDialog
import com.example.junstagram.view.ui.adapter.PhotoFocusListener
import com.example.junstagram.view.ui.adapter.PhotoPagingDataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {
    private val homeViewModel: HomeViewModel by viewModels()

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.apply {
            val photoPagingDataAdapter = PhotoPagingDataAdapter(homeViewModel)

            recyclerViewHomeFragment.apply {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)

                adapter = photoPagingDataAdapter
            }

            lifecycleScope.launch {
                homeViewModel.photoList.collectLatest { pagingData ->
                    photoPagingDataAdapter.submitData(pagingData)
                }
            }
        }

        homeViewModel.onPhotoFocusEvent.observe(viewLifecycleOwner, EventObserver {
            println("포토 아이디 $it")

        })
    }
}