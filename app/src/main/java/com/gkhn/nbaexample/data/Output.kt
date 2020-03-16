package com.gkhn.nbaexample.data

sealed class Output<out T: Any> {
    data class Success<out T : Any>(val data: T) : Output<T>()
    data class Error(val exception: Throwable) : Output<Nothing>()
}