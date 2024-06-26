package org.alexcawl.forecaster.common

import kotlinx.coroutines.flow.StateFlow

interface Producer<S> {
    val state: StateFlow<S>
}