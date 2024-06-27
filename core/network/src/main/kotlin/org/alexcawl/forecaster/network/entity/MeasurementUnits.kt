package org.alexcawl.forecaster.network.entity

sealed interface MeasurementUnits {
    val description: String

    data object Standard : MeasurementUnits {
        override val description: String
            get() = "standard"
    }

    data object Metric : MeasurementUnits {
        override val description: String
            get() = "metric"
    }

    data object Imperial : MeasurementUnits {
        override val description: String
            get() = "imperial"
    }
}
