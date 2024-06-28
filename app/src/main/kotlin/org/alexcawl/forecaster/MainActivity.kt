package org.alexcawl.forecaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import org.alexcawl.forecaster.current.ui.card.CurrentWeatherInfoFragment
import org.alexcawl.forecaster.current.ui.main.CurrentWeatherFragment
import org.alexcawl.forecaster.data.ThemeRepository
import org.alexcawl.forecaster.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = navController.createGraph(
            startDestination = "current_weather"
        ) {
            fragment<CurrentWeatherFragment>("current_weather")

            fragment<CurrentWeatherInfoFragment>("current_weather_info")
        }

    }
}
