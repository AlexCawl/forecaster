package org.alexcawl.forecaster.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.alexcawl.forecaster.common.PropertyRepository

abstract class DataStorePreferenceRepository<T>(
    private val dataStore: DataStore<Preferences>,
    private val key: Preferences.Key<T>,
    private val defaultValue: T
) : PropertyRepository<T> {
    final override suspend fun get(): T =
        dataStore.data.map { preferences -> preferences[key] ?: defaultValue }.first()

    final override suspend fun set(value: T) {
        dataStore.edit { preferences -> preferences[key] = value }
    }
}
