package com.example.junstagram.room

import android.content.Context
import androidx.room.*

@Database(entities = [GallerySelectData::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun GalleryDao() : GalleryDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context) : AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "gallery-database"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}