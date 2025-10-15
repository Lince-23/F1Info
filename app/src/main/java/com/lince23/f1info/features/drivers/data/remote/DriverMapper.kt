package com.lince23.f1info.features.drivers.data.remote

import com.lince23.f1info.features.drivers.domain.Driver

fun DriversApiModel.toModel(): Driver {
    return Driver(
        this.full_name,
        this.driver_number,
        this.headshot_url,
        this.team_name,
        this.team_colour
    )
}