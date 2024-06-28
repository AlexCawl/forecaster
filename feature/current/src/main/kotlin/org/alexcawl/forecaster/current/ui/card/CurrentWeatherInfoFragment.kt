package org.alexcawl.forecaster.current.ui.card

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import org.alexcawl.forecaster.current.R
import org.alexcawl.forecaster.current.databinding.FragmentCurrentWeatherInfoBinding
import org.alexcawl.forecaster.current.di.CurrentWeatherComponentHolder
import org.alexcawl.forecaster.ui.mvi.BaseFragment
import org.alexcawl.forecaster.ui.mvi.BaseStore
import org.alexcawl.forecaster.ui.mvi.store
import org.alexcawl.forecaster.ui.binding.viewBinding
import javax.inject.Inject

class CurrentWeatherInfoFragment : BaseFragment<CurrentWeatherInfoState, CurrentWeatherInfoAction>(R.layout.fragment_current_weather_info) {
    @Inject
    lateinit var storeFactory: CurrentWeatherInfoStore.Factory

    override val store: BaseStore<CurrentWeatherInfoState, CurrentWeatherInfoAction> by store { storeFactory.create() }

    override val binding: ViewBinding by viewBinding(FragmentCurrentWeatherInfoBinding::bind)

    override fun consume(action: CurrentWeatherInfoState) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CurrentWeatherComponentHolder.component.inject(this)
    }
}