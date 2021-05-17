package com.example.junstagram.util

import android.view.ViewTreeObserver
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.whenReadyDraw(action: RecyclerView.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            action.invoke(this@whenReadyDraw)
            viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    })
}

