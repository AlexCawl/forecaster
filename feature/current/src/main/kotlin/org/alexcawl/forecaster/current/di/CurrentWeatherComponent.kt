package org.alexcawl.forecaster.current.di

import dagger.Component
import org.alexcawl.forecaster.current.ui.card.CurrentWeatherInfoFragment
import org.alexcawl.forecaster.current.ui.card.CurrentWeatherInfoStore
import org.alexcawl.forecaster.current.ui.main.CurrentWeatherFragment

@CurrentWeatherScope
@Component(dependencies = [CurrentWeatherComponentDeps::class])
interface CurrentWeatherComponent {
    @Component.Factory
    interface Factory {
        fun create(componentDeps: CurrentWeatherComponentDeps): CurrentWeatherComponent
    }

    fun inject(currentWeatherFragment: CurrentWeatherFragment)

    fun inject(currentWeatherInfoStore: CurrentWeatherInfoFragment)
}