package org.alexcawl.forecaster.current.ui.main

sealed interface CurrentWeatherState {
    data object Initial : CurrentWeatherState
}