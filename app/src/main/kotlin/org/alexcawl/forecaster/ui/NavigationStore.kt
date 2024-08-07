package org.alexcawl.forecaster.ui

import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import org.alexcawl.forecaster.ui.mvi.BaseStore

class NavigationStore @AssistedInject constructor(

) : BaseStore<NavigationState, NavigationAction>(NavigationState.Loading), Navigator {
    @AssistedFactory
    interface Factory {
        fun create(): NavigationStore
    }

    override fun handle(action: NavigationAction) = when (action) {
        NavigationAction.NavigateToCurrentWeatherFragment -> task {
            reduce {
                NavigationState.CurrentWeather
            }
        }
    }

    override fun navigate(destination: String): Boolean {
        TODO("Not yet implemented")
    }
}