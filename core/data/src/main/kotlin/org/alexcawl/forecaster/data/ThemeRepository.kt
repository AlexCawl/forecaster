package org.alexcawl.forecaster.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import javax.inject.Inject

class ThemeRepository @Inject constructor(
    datastore: DataStore<Preferences>
) : DataStorePreferenceRepository<Boolean>(datastore, lightModeKey, false) {
    private companion object {
        const val PREFERENCE_NAME = "theme"
        const val LIGHT_MODE = "appInDarkMode"
        val lightModeKey = booleanPreferencesKey("${PREFERENCE_NAME}_$LIGHT_MODE")
    }
}
