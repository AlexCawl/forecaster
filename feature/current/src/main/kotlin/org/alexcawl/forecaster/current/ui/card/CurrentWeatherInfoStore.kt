package org.alexcawl.forecaster.current.ui.card

import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import org.alexcawl.forecaster.ui.mvi.BaseStore

class CurrentWeatherInfoStore @AssistedInject constructor(

) : BaseStore<CurrentWeatherInfoState, CurrentWeatherInfoAction>(CurrentWeatherInfoState.Initial) {
    @AssistedFactory
    interface Factory {
        fun create(): CurrentWeatherInfoStore
    }

    override fun handle(action: CurrentWeatherInfoAction) {
        TODO("Not yet implemented")
    }
}