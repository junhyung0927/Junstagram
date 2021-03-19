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

class CustomDialog(v: View): DialogFragment() {
    private val v = v
    private var dialog: AlertDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("test")
            builder.create()
        } ?: throw IllegalStateException("Error")

//        val mainDialog: AlertDialog.Builder = AlertDialog.Builder(
//            requireContext(), android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth)
//        mainDialog.setView(v)
//
//        v
//        dialog = mainDialog.create()
    }


}