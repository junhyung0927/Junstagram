package com.example.junstagram.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.junstagram.R
import com.example.junstagram.base.BaseActivity
import com.example.junstagram.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.photoView.setImageResource(R.drawable.sampleimage_1)

    }
}