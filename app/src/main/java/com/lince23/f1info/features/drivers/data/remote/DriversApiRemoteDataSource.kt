package com.lince23.f1info.features.drivers.data.remote

import com.lince23.f1info.core.api.ApiClient
import com.lince23.f1info.features.drivers.domain.Driver
import com.lince23.f1info.features.drivers.domain.ErrorApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DriversApiRemoteDataSource(private val apiClient: ApiClient) {
    suspend fun getDrivers(): Result<List<Driver>> {
        return withContext(Dispatchers.IO) {
            val apiService = apiClient.createService(DriverApiService::class.java)
            val resultDriver = apiService.findAll()

            if (resultDriver.isSuccessful && resultDriver.errorBody() == null) {
                Result.success(resultDriver.body()!!.map { driversApiModel ->
                    driversApiModel.toModel()
                })
            } else {
                Result.failure(ErrorApp.ServerError)
            }
        }
    }
}