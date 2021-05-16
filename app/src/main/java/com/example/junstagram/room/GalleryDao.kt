package com.example.junstagram.room

import androidx.room.*

@Dao
interface GalleryDao {
    @Query("SELECT * FROM GallerySelectData")
    fun getAllGalleryData() : List<GallerySelectData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGalleryImage(galleryData: GallerySelectData)

    @Delete
    fun delete(id: GallerySelectData)
}