package org.alexcawl.forecaster.common

interface PropertyRepository<T> {
    suspend fun get(): T

    suspend fun set(value: T)
}