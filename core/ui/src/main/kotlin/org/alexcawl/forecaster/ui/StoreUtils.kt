package org.alexcawl.forecaster.ui

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


inline fun <reified T : ViewModel> Fragment.store(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    StoreFactory(savedStateRegistryOwner = this, create = create)
}

inline fun <reified T : ViewModel> ComponentActivity.store(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    StoreFactory(savedStateRegistryOwner = this, create = create)
}
