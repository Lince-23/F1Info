package com.lince23.f1info.features.drivers.data.remote.api

import com.google.gson.annotations.SerializedName

data class DriversApiModel(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val nationality: String
)

data class ApiResponse(
    @SerializedName("MRData")
    val mrData: MRData
)
data class MRData(
    @SerializedName("DriverTable")
    val driverTable: DriverTable
)

data class DriverTable(
    @SerializedName("Drivers")
    val drivers: Array<DriversApiModel>
)
