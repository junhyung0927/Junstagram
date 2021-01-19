package com.example.junstagram.service

import android.app.Application
import android.content.Context

class ApplicationGetContext : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: ApplicationGetContext? = null
        fun ApplicationGetContext() : Context {
            return instance!!.applicationContext
        }
    }
}