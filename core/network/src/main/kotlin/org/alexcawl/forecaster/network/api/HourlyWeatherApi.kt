package org.alexcawl.forecaster.network.api

import org.alexcawl.forecaster.network.entity.MeasurementUnits
import org.alexcawl.forecaster.network.response.HourlyWeatherResponse

interface HourlyWeatherApi {
    suspend fun get(
        latitude: Float,
        longitude: Float,
        token: String,
        units: MeasurementUnits? = null,
        language: String? = null
    ): HourlyWeatherResponse
}