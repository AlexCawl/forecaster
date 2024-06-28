package org.alexcawl.forecaster.current.di

import org.alexcawl.forecaster.common.ComponentHolder

object CurrentWeatherComponentHolder : ComponentHolder<CurrentWeatherComponent, CurrentWeatherComponentDeps> {
    override lateinit var dependencies: CurrentWeatherComponentDeps

    override val component: CurrentWeatherComponent by lazy {
        DaggerCurrentWeatherComponent.factory().create(dependencies)
    }
}