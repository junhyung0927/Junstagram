package com.example.junstagram.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.junstagram.R
import com.example.junstagram.databinding.ActivityMainBinding
import com.example.junstagram.databinding.HomeFragmentBinding
import com.example.junstagram.model.PhotoPagedList
import com.example.junstagram.service.ApplicationGetContext
import com.example.junstagram.view.base.BaseFragment

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        homeViewModel.test.observe(viewLifecycleOwner, Observer { it ->
            binding.headText.text = it.title
            binding.photoView.setImageResource(it.image)
            binding.bodyText.text = it.bodyText
        })

        return binding.root
    }
}