package org.alexcawl.forecaster.ui.mvi

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.alexcawl.forecaster.common.Consumer
import org.alexcawl.forecaster.common.Producer

abstract class BaseStore<S, A>(initialState: S) : Producer<S>, Consumer<A>, ViewModel() {
    private val innerState: MutableStateFlow<S> = MutableStateFlow(initialState)
    private val innerActions = MutableSharedFlow<A>(0, Int.MAX_VALUE)
    private val dispatchChannel = Channel<suspend StoreContext<S>.() -> Unit>(Channel.UNLIMITED)
    private val context = StoreContext(innerState::update)

    init {
        viewModelScope.launch {
            launch {
                for (task in dispatchChannel) {
                    launch {
                        task(context)
                    }
                }
            }
            launch {
                innerActions.collect(::handle)
            }
        }
        println(this::class.java)
    }

    fun observe(
        lifecycleOwner: LifecycleOwner,
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        stateConsumer: Consumer<S>? = null
    ) {
        with(lifecycleOwner) {
            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(lifecycleState) {
                    stateConsumer?.let {
                        launch {
                            state.collect(stateConsumer::consume)
                        }
                    }
                }
            }
        }
    }

    final override val state: StateFlow<S> = innerState.asStateFlow()

    final override fun consume(action: A) {
        innerActions.tryEmit(action)
    }

    protected fun task(task: suspend StoreContext<S>.() -> Unit) {
        dispatchChannel.trySend(task)
    }

    protected abstract fun handle(action: A)
}