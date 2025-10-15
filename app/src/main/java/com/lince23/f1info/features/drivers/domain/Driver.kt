package com.lince23.f1info.features.drivers.domain

data class Driver(
    val fullName: String,
    val number: String,
    val image: String?,
    val team: String,
    val teamColor:String
)
