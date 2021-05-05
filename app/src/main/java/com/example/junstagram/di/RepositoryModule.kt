package com.example.junstagram.di

import com.example.junstagram.repository.PhotoRepository
import com.example.junstagram.repository.PhotoRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PhotoRepository> { PhotoRepositoryImpl(photoRemoteDataSource = get()) }
}