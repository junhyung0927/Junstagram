package com.example.junstagram.room

import android.net.Uri
import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromUriToString(value: Uri?) = value.toString()
}