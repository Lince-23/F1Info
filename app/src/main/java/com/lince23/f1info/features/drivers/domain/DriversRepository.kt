package com.lince23.f1info.features.drivers.domain

interface DriversRepository {
    suspend fun getAll(): Result<List<Driver>>
}