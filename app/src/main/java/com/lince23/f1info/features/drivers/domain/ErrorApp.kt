package com.lince23.f1info.features.drivers.domain

sealed class ErrorApp : Throwable() {
    object ServerError : ErrorApp()
    object InternetConnectionErrorApp : ErrorApp()
}