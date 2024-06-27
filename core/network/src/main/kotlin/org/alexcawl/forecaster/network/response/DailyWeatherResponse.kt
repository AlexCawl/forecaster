package org.alexcawl.forecaster.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.alexcawl.forecaster.network.entity.Weather

@Serializable
data class DailyWeatherResponse(
    @SerialName("city")
    val city: City,
    @SerialName("cnt")
    val cnt: Int,
    @SerialName("cod")
    val cod: String,
    @SerialName("list")
    val list: List<Item>,
    @SerialName("message")
    val message: Double
) {
    @Serializable
    data class City(
        @SerialName("coord")
        val coord: Coord,
        @SerialName("country")
        val country: String,
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
        @SerialName("population")
        val population: Int,
        @SerialName("timezone")
        val timezone: Int
    ) {
        @Serializable
        data class Coord(
            @SerialName("lat")
            val lat: Double,
            @SerialName("lon")
            val lon: Double
        )
    }

    @Serializable
    data class Item(
        @SerialName("clouds")
        val clouds: Int,
        @SerialName("deg")
        val deg: Int,
        @SerialName("dt")
        val dt: Int,
        @SerialName("feels_like")
        val feelsLike: FeelsLike,
        @SerialName("gust")
        val gust: Double,
        @SerialName("humidity")
        val humidity: Int,
        @SerialName("pop")
        val pop: Double,
        @SerialName("pressure")
        val pressure: Int,
        @SerialName("rain")
        val rain: Double,
        @SerialName("speed")
        val speed: Double,
        @SerialName("sunrise")
        val sunrise: Int,
        @SerialName("sunset")
        val sunset: Int,
        @SerialName("temp")
        val temp: Temp,
        @SerialName("weather")
        val weather: List<Weather>
    ) {
        @Serializable
        data class FeelsLike(
            @SerialName("day")
            val day: Double,
            @SerialName("eve")
            val eve: Double,
            @SerialName("morn")
            val morn: Double,
            @SerialName("night")
            val night: Double
        )

        @Serializable
        data class Temp(
            @SerialName("day")
            val day: Double,
            @SerialName("eve")
            val eve: Double,
            @SerialName("max")
            val max: Double,
            @SerialName("min")
            val min: Double,
            @SerialName("morn")
            val morn: Double,
            @SerialName("night")
            val night: Double
        )
    }
}
