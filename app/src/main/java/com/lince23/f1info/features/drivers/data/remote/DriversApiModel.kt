package com.lince23.f1info.features.drivers.data.remote

data class DriversApiModel(
    val driver_number: String,
    val full_name: String,
    val team_name: String,
    val headshot_url: String?,
    val team_colour: String
)
