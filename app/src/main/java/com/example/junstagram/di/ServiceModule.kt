package com.example.junstagram.di

import com.example.junstagram.data.PhotoDataSource
import com.example.junstagram.service.MockPhotoDataService
import com.example.junstagram.service.PhotoDataService
import org.koin.dsl.module

val serviceModule = module {
    single<PhotoDataService> { MockPhotoDataService() }
}