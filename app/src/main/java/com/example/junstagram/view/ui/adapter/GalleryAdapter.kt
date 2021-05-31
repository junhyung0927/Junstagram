package com.example.junstagram.view.ui.adapter

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.junstagram.databinding.GalleryGridItemBinding
import com.example.junstagram.util.whenReadyDraw as WhenReadyDraw
import com.example.junstagram.view.ui.fragment.InsertFragment
import java.io.File
import com.example.junstagram.view.ui.fragment.InsertViewModel
import org.koin.core.KoinApplication.Companion.init
import java.lang.Exception

class GalleryAdapter(val context: Context, val insertViewModel: InsertViewModel, var lastClickedPosition: Int) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    companion object {
        private const val previewMaxCount = 25
    }

    var selectedPhoto: Uri? = null
    private val galleryPhotoList: MutableList<Uri> = mutableListOf()
    private val cursor: Cursor?

    init {
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val columns: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
        val orderBy: String = MediaStore.Images.Media.DATE_ADDED + " DESC"

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
                    galleryPhotoList.add(Uri.fromFile(imageFile))
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
        holder.bind(galleryPhotoList.get(position))
    }

    override fun getItemCount(): Int {
        return galleryPhotoList.size
    }

    inner class GalleryViewHolder(val binding: GalleryGridItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uri: Uri) {
            Glide.with(context).load(uri).thumbnail(0.1f).into(binding.photoViewItemGridImage)

            if (lastClickedPosition.equals(bindingAdapterPosition)) {
                insertViewModel.callOnGallerySelectedEvent(uri)
                println("마지막 포지션 0이어야함: ${lastClickedPosition}")
            }

            binding.photoViewItemGridImage.setOnClickListener {
                uri.let {
                    lastClickedPosition = bindingAdapterPosition
                    notifyDataSetChanged()
                    println("마지막 포지션: ${lastClickedPosition}")
                }
            }
        }
    }
}