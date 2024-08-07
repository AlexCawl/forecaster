package org.alexcawl.forecaster.network.api.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.alexcawl.forecaster.network.api.CurrentWeatherApi
import org.alexcawl.forecaster.network.entity.MeasurementUnits
import org.alexcawl.forecaster.network.qualifiers.CurrentWeatherUrl
import org.alexcawl.forecaster.network.response.CurrentWeatherResponse
import javax.inject.Inject

class CurrentWeatherApiImpl @Inject constructor(
    @CurrentWeatherUrl private val baseUrl: String,
    private val httpClient: HttpClient
) : CurrentWeatherApi {
    override suspend fun get(
        latitude: Float,
        longitude: Float,
        token: String,
        units: MeasurementUnits?,
        language: String?
    ): CurrentWeatherResponse = httpClient.get(baseUrl) {
        parameter("lat", latitude)
        parameter("lon", longitude)
        parameter("appid", token)
        units?.let {
            parameter("units", units.description)
        }
        language?.let {
            parameter("lang", language)
        }
    }.body<CurrentWeatherResponse>()
}