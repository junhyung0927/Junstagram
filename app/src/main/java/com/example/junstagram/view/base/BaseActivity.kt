package com.example.junstagram.view.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity : AppCompatActivity() {
    protected inline fun<reified vb: ViewDataBinding> binding(resId: Int): Lazy<vb> =
        lazy { DataBindingUtil.setContentView<vb>(this, resId) }
}
