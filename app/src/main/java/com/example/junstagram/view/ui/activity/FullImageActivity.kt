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
        const val KEY_PHOTO_ID_FULL_IMAGE: String = "photoId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@FullImageActivity

            val intent = getIntent()
            val photoId = intent.getIntExtra(KEY_PHOTO_ID_FULL_IMAGE, 0)
            imageId = photoId
        }
    }
}



