package org.alexcawl.forecaster.network.api.impl

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import org.alexcawl.forecaster.network.api.CurrentWeatherApi
import org.alexcawl.forecaster.network.entity.MeasurementUnits
import org.alexcawl.forecaster.network.response.CurrentWeatherResponse
import javax.inject.Inject

class CurrentWeatherApiImpl @Inject constructor(
    private val baseWeatherUrl: String,
    private val httpClient: HttpClient
) : CurrentWeatherApi {
    override suspend fun get(latitude: Float, longitude: Float): CurrentWeatherResponse {
        TODO("Not yet implemented")
    }

    override suspend fun get(
        latitude: Float,
        longitude: Float,
        units: MeasurementUnits,
        language: String
    ): CurrentWeatherResponse {
        TODO("Not yet implemented")
    }
}