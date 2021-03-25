package com.example.junstagram.view.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.junstagram.R
import com.example.junstagram.view.base.BaseActivity
import com.example.junstagram.databinding.ActivityMainBinding
import com.example.junstagram.view.ui.adapter.PagerAdapter

class MainActivity : BaseActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            mainViewpager2.adapter = PagerAdapter(this@MainActivity)

            mainViewpager2.registerOnPageChangeCallback( object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.mainBottomAppbar.menu.getItem(position).isChecked = true
                    binding.mainBottomAppbar.selectedItemId = when (position) {
                        0 -> R.id.page_1
                        1 -> R.id.page_2
                        2 -> R.id.page_3
                        3 -> R.id.page_4
                        4 -> R.id.page_5
                        else -> error(" 존재하지 않는 페이지 ")
                    }
                }
            })

            mainBottomAppbar.setOnNavigationItemSelectedListener { item ->
                binding.mainViewpager2.currentItem =
                    when (item.itemId) {
                        R.id.page_1 -> 0
                        R.id.page_2 -> 1
                        R.id.page_3 -> 2
                        R.id.page_4 -> 3
                        R.id.page_5 -> 4
                        else -> error(" 존재하지 않는 페이지 ")
                    }
                false
            }
        }
    }
}