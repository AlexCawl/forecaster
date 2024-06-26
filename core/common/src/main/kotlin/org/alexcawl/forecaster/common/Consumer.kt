package org.alexcawl.forecaster.common

interface Consumer<A> {
    fun consume(action: A)
}