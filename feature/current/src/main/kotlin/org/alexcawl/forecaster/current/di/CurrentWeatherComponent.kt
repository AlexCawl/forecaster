package org.alexcawl.forecaster.current.di

import dagger.Component
import org.alexcawl.forecaster.current.ui.CurrentWeatherFragment

@CurrentWeatherScope
@Component(dependencies = [CurrentWeatherComponentDeps::class])
interface CurrentWeatherComponent {
    @Component.Factory
    interface Factory {
        fun create(componentDeps: CurrentWeatherComponentDeps): CurrentWeatherComponent
    }

    fun inject(currentWeatherFragment: CurrentWeatherFragment)
}