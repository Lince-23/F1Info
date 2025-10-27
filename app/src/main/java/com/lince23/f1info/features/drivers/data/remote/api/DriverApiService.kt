package com.lince23.f1info.features.drivers.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface DriverApiService {
    @GET("2025/drivers")
    suspend fun findAll(): Response<List<DriversApiModel>>
}