package com.lince23.f1info.features.drivers.data.remote.api

data class DriversApiModel(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val nationality: String
)
