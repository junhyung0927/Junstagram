package com.example.junstagram.view.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity : AppCompatActivity() {
    protected fun<VB: ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<VB> =
        lazy { DataBindingUtil.setContentView<VB>(this, resId) }
}
