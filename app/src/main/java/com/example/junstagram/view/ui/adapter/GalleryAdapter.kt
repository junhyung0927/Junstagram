package com.example.junstagram.view.ui.adapter

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.junstagram.databinding.GalleryGridItemBinding
import com.example.junstagram.view.ui.fragment.InsertFragment
import java.io.File
import java.lang.Exception

class GalleryAdapter(val context: Context) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    companion object {
        private const val previewMaxCount = 25
    }

    var selectedPhoto: Uri? = null
    private val galleryPhotoList: MutableList<Uri>? = null
    private val cursor: Cursor?

    init {
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val columns: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
        val orderBy: String = MediaStore.Images.Media.DATE_ADDED + "DESC"

        cursor = context.applicationContext.contentResolver.query(
            uri, columns, null, null, orderBy
        )

        cursor.use {
            var count: Int = 0
            if (cursor != null) {
                while (cursor.moveToNext() && count < previewMaxCount) {
                    val dataIndex: String = MediaStore.Images.Media.DATA
                    val imageLocation: String = cursor.getString(cursor.getColumnIndex(dataIndex))
                    val imageFile = File(imageLocation)
                    galleryPhotoList?.add(Uri.fromFile(imageFile))
                    count++
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            GalleryGridItemBinding.inflate(
                LayoutInflater.from(parent.context), null, false
            )
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        var isSelected = false
        val currentUri: Uri? = galleryPhotoList?.get(position)

        Glide.with(context)
            .load(currentUri)
            .thumbnail(0.1f)
            .into(holder.binding.photoViewItemGridImage)


    }

    override fun getItemCount(): Int {
        return itemCount
    }

    inner class GalleryViewHolder(val binding: GalleryGridItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun setSelectedUri(selectedUri: Uri) {

    }
}