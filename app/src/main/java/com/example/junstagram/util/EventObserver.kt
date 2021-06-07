package com.example.junstagram.util

import androidx.annotation.MainThread
import java.util.*
import androidx.lifecycle.Observer
import kotlin.reflect.KFunction0

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}