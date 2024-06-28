package org.alexcawl.forecaster.ui

sealed interface NavigationAction {
    data object NavigateToCurrentWeatherFragment : NavigationAction
}