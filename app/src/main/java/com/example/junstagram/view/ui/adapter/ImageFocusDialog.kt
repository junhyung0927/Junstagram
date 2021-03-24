package com.example.junstagram.view.ui.adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.junstagram.R
import com.github.chrisbanes.photoview.PhotoView
import java.lang.IllegalStateException

class ImageFocusDialog: DialogFragment() {
    companion object {
        fun newInstance(photoId: Int): ImageFocusDialog {
            val args = Bundle()
            args.putInt("photoId", photoId)
            return ImageFocusDialog()
        }
    }

    private val photoId by lazy {
        requireArguments().getInt("photoId")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            photoId
            val builder = AlertDialog.Builder(it)
            builder.setMessage("test")
            builder.create()
        } ?: throw IllegalStateException("Error")
    }
}