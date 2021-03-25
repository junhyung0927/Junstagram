package com.example.junstagram.view.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junstagram.R
import com.example.junstagram.databinding.FragmentHomeBinding
import com.example.junstagram.util.EventObserver
import com.example.junstagram.view.base.BaseFragment
import com.example.junstagram.view.ui.activity.FullImageActivity
import com.example.junstagram.view.ui.activity.FullImageActivity.Companion.KEY_PHOTO_ID_FULL_IMAGE
import com.example.junstagram.view.ui.adapter.PhotoPagingDataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
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
            val intent = Intent(activity, FullImageActivity::class.java)
            intent.putExtra(KEY_PHOTO_ID_FULL_IMAGE, it)
            startActivity(intent)
        })
    }
}