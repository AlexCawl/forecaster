package org.alexcawl.forecaster.current.ui.main

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import org.alexcawl.forecaster.current.R
import org.alexcawl.forecaster.current.databinding.FragmentCurrentWeatherBinding
import org.alexcawl.forecaster.current.di.CurrentWeatherComponentHolder
import org.alexcawl.forecaster.ui.mvi.BaseFragment
import org.alexcawl.forecaster.ui.mvi.BaseStore
import org.alexcawl.forecaster.ui.mvi.store
import org.alexcawl.forecaster.ui.binding.viewBinding
import javax.inject.Inject

class CurrentWeatherFragment : BaseFragment<CurrentWeatherState, CurrentWeatherAction>(R.layout.fragment_current_weather) {
    @Inject
    lateinit var storeFactory: CurrentWeatherStore.Factory

    override val store: BaseStore<CurrentWeatherState, CurrentWeatherAction> by store { storeFactory.create() }
    override val binding: ViewBinding by viewBinding(FragmentCurrentWeatherBinding::bind)

    override fun consume(action: CurrentWeatherState) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CurrentWeatherComponentHolder.component.inject(this)
    }
}