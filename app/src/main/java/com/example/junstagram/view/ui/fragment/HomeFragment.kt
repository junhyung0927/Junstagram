package com.example.junstagram.view.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.junstagram.R
import com.example.junstagram.databinding.FragmentHomeBinding
import com.example.junstagram.di.viewModelModule
import com.example.junstagram.util.EventObserver
import com.example.junstagram.view.base.BaseFragment
import com.example.junstagram.view.ui.activity.FullImageActivity
import com.example.junstagram.view.ui.activity.FullImageActivity.Companion.KEY_PHOTO_ID_FULL_IMAGE
import com.example.junstagram.view.ui.adapter.PhotoPagingDataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    //import org.koin.android.viewmodel.ext.android.viewModel => koin
    private val homeViewModel: HomeViewModel by viewModel()

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
            homeViewModel.photoList.observe(viewLifecycleOwner) {
                photoPagingDataAdapter.submitData(lifecycle, it)
            }
        }
        
        homeViewModel.onPhotoFocusEvent.observe(viewLifecycleOwner, EventObserver {
            val intent = Intent(activity, FullImageActivity::class.java)
            intent.putExtra(KEY_PHOTO_ID_FULL_IMAGE, it)
            startActivity(intent)
        })
    }
}