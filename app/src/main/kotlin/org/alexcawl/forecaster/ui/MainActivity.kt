package org.alexcawl.forecaster.ui

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import org.alexcawl.forecaster.ForecasterApplication
import org.alexcawl.forecaster.current.ui.CurrentWeatherFragment
import org.alexcawl.forecaster.databinding.ActivityMainBinding
import org.alexcawl.forecaster.ui.mvi.BaseActivity
import org.alexcawl.forecaster.ui.mvi.BaseStore
import org.alexcawl.forecaster.ui.mvi.store
import javax.inject.Inject

class MainActivity : BaseActivity<NavigationState, NavigationAction>() {
    @Inject
    lateinit var storeFactory: NavigationStore.Factory
    private lateinit var binding: ActivityMainBinding

    override val store: BaseStore<NavigationState, NavigationAction> by store { storeFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        val screen = installSplashScreen()
        (applicationContext as ForecasterApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        screen.setKeepOnScreenCondition { store.state.value == NavigationState.Loading }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        store.consume(NavigationAction.NavigateToCurrentWeatherFragment)
    }

    override fun consume(action: NavigationState) = when (action) {
        NavigationState.CurrentWeather -> supportFragmentManager.commit {
            replace<CurrentWeatherFragment>(org.alexcawl.forecaster.R.id.fragment_container_view)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            addToBackStack(action.destination)
        }
        else -> Unit
    }
}
