package com.example.junstagram.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.example.junstagram.R
import com.example.junstagram.databinding.ActivityFullImageBinding
import com.example.junstagram.databinding.ActivityMainBinding
import com.example.junstagram.view.base.BaseActivity
import java.lang.IllegalStateException

class FullImageActivity : BaseActivity() {
    private val binding by binding<ActivityFullImageBinding>(R.layout.activity_full_image)

    companion object {
        var KEY_PHOTO_ID_FULL_IMAGE: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@FullImageActivity

            val intent = getIntent()
            KEY_PHOTO_ID_FULL_IMAGE = intent.getIntExtra("photoId", 0)
            imageId = KEY_PHOTO_ID_FULL_IMAGE
        }
    }
}



