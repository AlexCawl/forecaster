package org.alexcawl.forecaster.ui.mvi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.alexcawl.forecaster.common.Consumer

abstract class BaseActivity<S, A> : Consumer<S>, AppCompatActivity() {
    protected abstract val store: BaseStore<S, A>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        store.observe(lifecycleOwner = this, stateConsumer = this)
    }
}