package com.lince23.f1info.features.drivers.domain

class GetDriversListUseCase(private val driversRepository: DriversRepository) {
    suspend operator fun invoke(): Result<List<Driver>>{
        return driversRepository.getAll()
    }
}