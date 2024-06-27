package org.alexcawl.forecaster.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.alexcawl.forecaster.network.entity.Coordinates
import org.alexcawl.forecaster.network.entity.Weather
import org.alexcawl.forecaster.network.entity.Wind

@Serializable
data class HourlyWeatherResponse(
    @SerialName("city") val city: City,
    @SerialName("cnt") val cnt: Int,
    @SerialName("cod") val cod: String,
    @SerialName("list") val list: List<Item>,
    @SerialName("message") val message: Int
) {
    @Serializable
    data class City(
        @SerialName("coord") val coordinates: Coordinates,
        @SerialName("country") val country: String,
        @SerialName("id") val id: Int,
        @SerialName("name") val name: String,
        @SerialName("population") val population: Int,
        @SerialName("sunrise") val sunrise: Int,
        @SerialName("sunset") val sunset: Int,
        @SerialName("timezone") val timezone: Int
    )

    @Serializable
    data class Item(
        @SerialName("clouds") val clouds: Clouds,
        @SerialName("dt") val dt: Int,
        @SerialName("dt_txt") val dtTxt: String,
        @SerialName("main") val main: Main,
        @SerialName("pop") val pop: Double,
        @SerialName("rain") val rain: Rain?,
        @SerialName("sys") val sys: Sys,
        @SerialName("visibility") val visibility: Int,
        @SerialName("weather") val weather: List<Weather>,
        @SerialName("wind") val wind: Wind
    ) {
        @Serializable
        data class Clouds(
            @SerialName("all") val all: Int
        )

        @Serializable
        data class Main(
            @SerialName("feels_like") val feelsLike: Double,
            @SerialName("grnd_level") val grndLevel: Int,
            @SerialName("humidity") val humidity: Int,
            @SerialName("pressure") val pressure: Int,
            @SerialName("sea_level") val seaLevel: Int,
            @SerialName("temp") val temp: Double,
            @SerialName("temp_kf") val tempKf: Double,
            @SerialName("temp_max") val tempMax: Double,
            @SerialName("temp_min") val tempMin: Double
        )

        @Serializable
        data class Rain(
            @SerialName("3h") val h: Double
        )

        @Serializable
        data class Sys(
            @SerialName("pod") val pod: String
        )
    }
}
