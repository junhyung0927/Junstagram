package com.example.junstagram.room

import android.content.Context
import androidx.room.*
import com.example.junstagram.model.GallerySelectData

@Database(entities = [GallerySelectData::class], version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun galleryDao() : GalleryDao

    companion object {
        const val DATABASE_NAME = "gallery-database"
    }
}