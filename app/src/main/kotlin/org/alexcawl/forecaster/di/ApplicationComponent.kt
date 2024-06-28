package org.alexcawl.forecaster.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.alexcawl.forecaster.MainActivity
import org.alexcawl.forecaster.current.di.CurrentWeatherComponentDeps
import org.alexcawl.forecaster.data.DataModule
import org.alexcawl.forecaster.network.NetworkModule

@ApplicationScope
@Component(modules = [NetworkModule::class, DataModule::class])
interface ApplicationComponent : CurrentWeatherComponentDeps {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(mainActivity: MainActivity)
}