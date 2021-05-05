package com.example.junstagram.view.ui.activity

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.junstagram.R
import com.example.junstagram.view.base.BaseActivity
import com.example.junstagram.databinding.ActivityMainBinding
import com.example.junstagram.view.ui.adapter.PagerAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : BaseActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            viewPager2Main.adapter = PagerAdapter(this@MainActivity)

            viewPager2Main.registerOnPageChangeCallback( object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationViewMain.menu.getItem(position).isChecked = true
                    binding.bottomNavigationViewMain.selectedItemId = when (position) {
                        0 -> R.id.page_1
                        1 -> R.id.page_2
                        2 -> R.id.page_3
                        3 -> R.id.page_4
                        4 -> R.id.page_5
                        else -> error(" 존재하지 않는 페이지 ")
                    }
                }
            })

            bottomNavigationViewMain.setOnNavigationItemSelectedListener { item ->
                binding.viewPager2Main.currentItem =
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