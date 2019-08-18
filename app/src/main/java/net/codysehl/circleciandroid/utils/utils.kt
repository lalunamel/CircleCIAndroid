package net.codysehl.circleciandroid.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, observer: (T) -> Unit) {
    this.observe(owner, Observer<T> { t ->
        if(t == null) {
            throw NullPointerException("Value in LiveData was null")
        } else {
            observer(t)
        }
    })
}

val <T> T.exhaustive: T
    get() = this