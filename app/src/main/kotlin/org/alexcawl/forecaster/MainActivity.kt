package org.alexcawl.forecaster

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import org.alexcawl.forecaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val ANIM_FADE_ENTER = 1500
        private const val ANIM_FADE_EXIT = 2500
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var animatedBackground: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        animatedBackground = binding.root.background as AnimationDrawable
        animatedBackground.setEnterFadeDuration(ANIM_FADE_ENTER)
        animatedBackground.setExitFadeDuration(ANIM_FADE_EXIT)
        animatedBackground.start()
    }

    override fun onStop() {
        super.onStop()
        animatedBackground.stop()
    }
}