package com.example.fayproject.models

/**
 * Data that is Observable with multiple states
 */
sealed interface ObservableData<out T> {
    data class Data<T>(val data: T) : ObservableData<T>
    data object Loading : ObservableData<Nothing>
    data class Error(val error: Throwable) : ObservableData<Nothing>
}
