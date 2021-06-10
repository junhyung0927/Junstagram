package com.example.junstagram.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.junstagram.model.GallerySelectData

@Dao
interface GalleryDao {
    @Query("SELECT * FROM GallerySelectData")
    fun getAllGalleryData() : List<GallerySelectData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGalleryImage(vararg galleryData: GallerySelectData)

    @Delete
    fun delete(vararg id: GallerySelectData)
}