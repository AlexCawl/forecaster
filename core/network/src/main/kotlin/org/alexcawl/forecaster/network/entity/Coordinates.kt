package org.alexcawl.forecaster.network.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double
)