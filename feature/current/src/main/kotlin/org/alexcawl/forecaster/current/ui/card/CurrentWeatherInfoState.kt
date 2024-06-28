package org.alexcawl.forecaster.current.ui.card

sealed interface CurrentWeatherInfoState {
    data object Initial : CurrentWeatherInfoState
}