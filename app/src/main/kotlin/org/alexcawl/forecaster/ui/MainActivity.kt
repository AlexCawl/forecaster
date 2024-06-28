package org.alexcawl.forecaster.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import org.alexcawl.forecaster.ForecasterApplication
import org.alexcawl.forecaster.current.ui.card.CurrentWeatherInfoFragment
import org.alexcawl.forecaster.current.ui.main.CurrentWeatherFragment
import org.alexcawl.forecaster.databinding.ActivityMainBinding
import org.alexcawl.forecaster.ui.mvi.BaseActivity
import org.alexcawl.forecaster.ui.mvi.BaseStore
import org.alexcawl.forecaster.ui.mvi.store
import javax.inject.Inject

class MainActivity : BaseActivity<NavigationState, NavigationAction>() {
    @Inject
    lateinit var storeFactory: NavigationStore.Factory
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override val store: BaseStore<NavigationState, NavigationAction> by store { storeFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as ForecasterApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = (supportFragmentManager
            .findFragmentById(org.alexcawl.forecaster.R.id.fragment_container_view) as NavHostFragment)
            .navController
    }

    override fun onStart() {
        super.onStart()
        navController.apply {
            graph = createGraph(startDestination = "current_weather") {
                fragment<CurrentWeatherFragment>("current_weather")
                fragment<CurrentWeatherInfoFragment>("current_weather_info")
            }
        }
    }

    override fun consume(action: NavigationState) {

    }
}
