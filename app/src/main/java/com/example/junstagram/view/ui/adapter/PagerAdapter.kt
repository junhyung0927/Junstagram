package com.example.junstagram.view.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.junstagram.view.ui.fragment.*

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> imsiFragment1()
            2 -> imsiFragment2()
            3 -> imsiFragment3()
            4 -> imsiFragment4()
            else -> error(" 존재하지 않는 프래그먼트 ")
        }
    }
}

