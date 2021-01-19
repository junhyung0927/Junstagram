package com.example.junstagram.view.ui.main

import android.os.Bundle
import android.print.PageRange
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.junstagram.R
import com.example.junstagram.view.base.BaseActivity
import com.example.junstagram.databinding.ActivityMainBinding
import com.example.junstagram.service.ApplicationGetContext
import com.example.junstagram.view.ui.adapter.PagerAdapter

class MainActivity : BaseActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.viewPager.adapter = PagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.registerOnPageChangeCallback( PageChangeCallback() )
        binding.bottomAppBar.setOnNavigationItemSelectedListener { navigationSelected((it)) }
    }

    private fun navigationSelected(item: MenuItem): Boolean {
        val checked = item.setChecked(true)

        when (checked.itemId) {
            R.id.page_1 -> {
                binding.viewPager.currentItem = 0
                return true
            }
            R.id.page_2 -> {
                binding.viewPager.currentItem = 1
                return true
            }
            R.id.page_3 -> {
                binding.viewPager.currentItem = 2
                return true
            }
            R.id.page_4 -> {
                binding.viewPager.currentItem = 3
                return true
            }
            R.id.page_5 -> {
                binding.viewPager.currentItem = 4
                return true
            }
        }
        return false
    }

    private inner class PageChangeCallback: ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.bottomAppBar.selectedItemId = when (position) {
                0 -> R.id.page_1
                1 -> R.id.page_2
                2 -> R.id.page_3
                3 -> R.id.page_4
                4 -> R.id.page_5
                else -> error(" 존재하지 않는 페이지 ")
            }
        }
    }
}