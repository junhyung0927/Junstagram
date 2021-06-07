package com.example.junstagram.room

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromUriToString(value: Uri?) = value.toString()

    @TypeConverter
    fun fromStringToUri(value: String?) = value?.toUri()
}