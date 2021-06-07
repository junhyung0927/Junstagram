package com.example.junstagram.di

import com.example.junstagram.data.LocalDataSource
import com.example.junstagram.data.PhotoDataSource
import com.example.junstagram.data.PhotoLocalDataSource
import com.example.junstagram.data.PhotoRemoteDataSource
import com.example.junstagram.repository.PhotoPagingSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<PhotoDataSource> { PhotoRemoteDataSource(photoDataService = get()) }
    single<LocalDataSource> { PhotoLocalDataSource(galleryDao = get() ) }
    single<PhotoPagingSource> { PhotoPagingSource(photoDataSource = get()
    ) }
}