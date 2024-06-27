package org.alexcawl.forecaster.network.api

import org.alexcawl.forecaster.network.entity.MeasurementUnits
import org.alexcawl.forecaster.network.response.HourlyWeatherResponse

interface HourlyWeatherApi {
    suspend fun get(latitude: Float, longitude: Float): HourlyWeatherResponse

    suspend fun get(
        latitude: Float,
        longitude: Float,
        units: MeasurementUnits = MeasurementUnits.Standard,
        language: String
    ): HourlyWeatherResponse
}