package com.lince23.f1info.features.drivers.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface DriverApiService {
    @GET("drivers?meeting_key=1270")
    suspend fun findAll(): Response<List<DriversApiModel>>
}