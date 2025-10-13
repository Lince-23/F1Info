package com.lince23.f1info.features.drivers.data.remote

data class DriversApiModel(
    val full_name: String,
    val driver_number: String,
    val country_code: String,
    val headshot_url: String,
    val team_name: String
)
