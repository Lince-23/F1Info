package com.lince23.f1info.features.drivers.data

import com.lince23.f1info.features.drivers.data.remote.DriversApiRemoteDataSource
import com.lince23.f1info.features.drivers.domain.Driver
import com.lince23.f1info.features.drivers.domain.DriversRepository

class DriversDataRepository(private val driversApiRemoteDataSource: DriversApiRemoteDataSource): DriversRepository {
    override suspend fun getAll(): Result<List<Driver>> {
        return driversApiRemoteDataSource.getDrivers()
    }
}