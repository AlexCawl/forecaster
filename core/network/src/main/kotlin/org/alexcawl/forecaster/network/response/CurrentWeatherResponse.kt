package org.alexcawl.forecaster.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.alexcawl.forecaster.network.entity.Weather
import org.alexcawl.forecaster.network.entity.Wind

@Serializable
data class CurrentWeatherResponse(
    @SerialName("base")
    val base: String,
    @SerialName("clouds")
    val clouds: Clouds,
    @SerialName("cod")
    val cod: Int,
    @SerialName("coord")
    val coord: Coord,
    @SerialName("dt")
    val dt: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val main: Main,
    @SerialName("name")
    val name: String,
    @SerialName("sys")
    val sys: Sys,
    @SerialName("timezone")
    val timezone: Int,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("weather")
    val weather: List<Weather>,
    @SerialName("wind")
    val wind: Wind,
    @SerialName("rain")
    val rain: Rain? = null,
    @SerialName("snow")
    val snow: Snow? = null,
) {
    @Serializable
    data class Clouds(
        @SerialName("all")
        val all: Int
    )

    @Serializable
    data class Coord(
        @SerialName("lat")
        val lat: Double,
        @SerialName("lon")
        val lon: Double
    )

    @Serializable
    data class Main(
        @SerialName("feels_like")
        val feelsLike: Double,
        @SerialName("grnd_level")
        val grndLevel: Int,
        @SerialName("humidity")
        val humidity: Int,
        @SerialName("pressure")
        val pressure: Int,
        @SerialName("sea_level")
        val seaLevel: Int,
        @SerialName("temp")
        val temp: Double,
        @SerialName("temp_max")
        val tempMax: Double,
        @SerialName("temp_min")
        val tempMin: Double
    )

    @Serializable
    data class Rain(
        @SerialName("1h")
        val h1: Double?,
        @SerialName("3h")
        val h3: Double?
    )

    @Serializable
    data class Snow(
        @SerialName("1h")
        val h1: Double?,
        @SerialName("3h")
        val h3: Double?
    )

    @Serializable
    data class Sys(
        @SerialName("country")
        val country: String,
        @SerialName("id")
        val id: Int,
        @SerialName("sunrise")
        val sunrise: Int,
        @SerialName("sunset")
        val sunset: Int,
        @SerialName("type")
        val type: Int
    )
}
