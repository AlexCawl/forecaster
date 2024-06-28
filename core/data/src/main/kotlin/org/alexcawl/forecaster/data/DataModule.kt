package org.alexcawl.forecaster.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

        @Provides
        fun provideDataStore(context: Context): DataStore<Preferences> = context.dataStore
    }
}