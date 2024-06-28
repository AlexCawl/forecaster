package org.alexcawl.forecaster

import android.app.Application
import org.alexcawl.forecaster.current.di.CurrentWeatherComponentHolder
import org.alexcawl.forecaster.di.ApplicationComponent
import org.alexcawl.forecaster.di.DaggerApplicationComponent

class ForecasterApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
        CurrentWeatherComponentHolder.dependencies = applicationComponent
    }
}