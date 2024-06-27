package org.alexcawl.forecaster.network.api.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.alexcawl.forecaster.network.api.DailyWeatherApi
import org.alexcawl.forecaster.network.entity.MeasurementUnits
import org.alexcawl.forecaster.network.qualifiers.DailyWeatherUrl
import org.alexcawl.forecaster.network.response.DailyWeatherResponse
import javax.inject.Inject

class DailyWeatherApiImpl @Inject constructor(
    @DailyWeatherUrl private val baseUrl: String,
    private val httpClient: HttpClient
) : DailyWeatherApi {
    override suspend fun get(
        latitude: Float,
        longitude: Float,
        token: String,
        units: MeasurementUnits?,
        language: String?
    ): DailyWeatherResponse = httpClient.get(baseUrl) {
        parameter("lat", latitude)
        parameter("lon", longitude)
        parameter("appid", token)
        units?.let {
            parameter("units", units.description)
        }
        language?.let {
            parameter("lang", language)
        }
    }.body<DailyWeatherResponse>()
}