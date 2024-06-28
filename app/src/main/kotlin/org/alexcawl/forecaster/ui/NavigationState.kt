package org.alexcawl.forecaster.ui

sealed interface NavigationState {
    val destination: String

    data object Loading : NavigationState {
        override val destination: String = ""
    }

    data object CurrentWeather : NavigationState {
        override val destination: String = "current_weather"
    }

    data object DailyWeather : NavigationState {
        override val destination: String = "daily_weather"
    }

    data object Settings : NavigationState {
        override val destination: String = "settings"
    }
}