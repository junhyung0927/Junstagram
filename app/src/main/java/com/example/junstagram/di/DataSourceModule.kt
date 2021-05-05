package com.example.junstagram.di

import com.example.junstagram.data.PhotoDataSource
import com.example.junstagram.data.PhotoRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<PhotoDataSource> { PhotoRemoteDataSource(mockData = get()) }
}