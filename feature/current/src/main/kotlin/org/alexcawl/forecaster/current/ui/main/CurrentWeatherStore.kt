package org.alexcawl.forecaster.current.ui.main

import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import org.alexcawl.forecaster.ui.BaseStore

class CurrentWeatherStore @AssistedInject constructor(

) : BaseStore<CurrentWeatherState, CurrentWeatherAction>(CurrentWeatherState.Initial) {
    @AssistedFactory
    interface Factory {
        fun create(): CurrentWeatherStore
    }

    override fun handle(action: CurrentWeatherAction) {
        TODO("Not yet implemented")
    }
}