package org.alexcawl.forecaster.network.api

import org.alexcawl.forecaster.network.entity.MeasurementUnits
import org.alexcawl.forecaster.network.response.CurrentWeatherResponse

interface CurrentWeatherApi {
    suspend fun get(
        latitude: Float,
        longitude: Float,
        token: String,
        units: MeasurementUnits? = null,
        language: String? = null
    ): CurrentWeatherResponse
}
