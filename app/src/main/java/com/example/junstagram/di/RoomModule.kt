package com.example.junstagram.di

import androidx.room.Room
import com.example.junstagram.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration() //기존 데이터 삭제
            .build()
    }

    single {
        get<AppDatabase>().galleryDao()
    }
}