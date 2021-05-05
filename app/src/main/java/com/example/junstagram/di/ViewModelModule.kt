package com.example.junstagram.di

import com.example.junstagram.view.ui.fragment.HomeViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { HomeViewModel(photoRepository = get()) }
}