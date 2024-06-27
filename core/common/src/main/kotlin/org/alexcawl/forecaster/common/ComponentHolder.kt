package org.alexcawl.forecaster.common

interface ComponentHolder<C, D> {
    var dependencies: D

    val component: C
}