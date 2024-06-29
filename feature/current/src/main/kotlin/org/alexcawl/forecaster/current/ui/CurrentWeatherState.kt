package org.alexcawl.forecaster.current.ui

sealed interface CurrentWeatherState {
    data object Initial : CurrentWeatherState
}