package com.lince23.f1info.features.drivers.data.remote.api

import com.lince23.f1info.features.drivers.domain.Driver

fun DriversApiModel.toModel(): Driver {
    return Driver(
        this.driverId,
        this.permanentNumber,
        this.code,
        this.url,
        this.givenName,
        this.familyName,
        this.nationality
    )
}