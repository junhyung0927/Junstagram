package com.example.junstagram.view.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.junstagram.R
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.view.base.BaseFragment
import com.example.junstagram.view.ui.adapter.PhotoPagingDataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        homeViewModel.photoPagedList.observe(viewLifecycleOwner, Observer {
//            binding.headText.text = it.title
//            binding.photoView.setImageResource(it.image)
//            binding.bodyText.text = it.bodyText
//        })

//        homeViewModel.photoPagedList.value
//
//        homeViewModel.refreshFun()
//        //변화가 필요할 때
//        homeViewModel.testId.observe(viewLifecycleOwner, Observer {
//
//        })

        binding.apply {
            val adapter = PhotoPagingDataAdapter()
            binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            binding.recyclerView.setHasFixedSize(true)
            binding.recyclerView.adapter = adapter

            lifecycleScope.launch {
                homeViewModel.photoList.collectLatest { pagingData ->
                    adapter.submitData(pagingData)
                }
            }
        }

    }
}