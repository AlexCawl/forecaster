package org.alexcawl.forecaster.network

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.alexcawl.forecaster.network.api.CurrentWeatherApi
import org.alexcawl.forecaster.network.api.impl.CurrentWeatherApiImpl
import org.alexcawl.forecaster.network.qualifiers.CurrentWeatherUrl
import org.alexcawl.forecaster.network.qualifiers.DailyWeatherUrl
import org.alexcawl.forecaster.network.qualifiers.HourlyWeatherUrl
import javax.inject.Singleton

@Module
interface NetworkModule {
    @Binds
    fun bindCurrentWeatherApi(impl: CurrentWeatherApiImpl): CurrentWeatherApi

    companion object {
        @Provides
        @Singleton
        fun provideKtorClient(): HttpClient = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        useAlternativeNames = true
                        ignoreUnknownKeys = true
                        encodeDefaults = true
                    },
                    contentType = ContentType.Application.Json
                )
            }

            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.INFO
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

        @Provides
        @Singleton
        @CurrentWeatherUrl
        fun provideCurrentWeatherUrl(): String = "https://api.openweathermap.org/data/2.5/weather"

        @Provides
        @Singleton
        @HourlyWeatherUrl
        fun provideHourlyWeatherUrl(): String = "https://api.openweathermap.org/data/2.5/forecast"

        @Provides
        @Singleton
        @DailyWeatherUrl
        fun provideDailyWeatherUrl(): String = "https://api.openweathermap.org/data/2.5/forecast/daily"
    }
}