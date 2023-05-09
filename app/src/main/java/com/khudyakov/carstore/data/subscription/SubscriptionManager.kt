package com.khudyakov.carstore.data.subscription

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.datastore by preferencesDataStore("settings")

@Singleton
class SubscriptionManager @Inject constructor(@ApplicationContext context: Context) {

    private val dataStore = context.datastore

    private val freeShowCount = 3
    private val freeUploadCount = 2

    private val subscribedKey = booleanPreferencesKey("subscribed")
    private val showCountKey = intPreferencesKey("shows")
    private val uploadCountKey = intPreferencesKey("uploads")

    fun isSubscribed(): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[subscribedKey] ?: false
    }

    fun canShow(): Flow<Boolean> = dataStore.data.map { preferences ->
        (preferences[showCountKey] ?: 0) < freeShowCount
    }

    fun canUpload(): Flow<Boolean> = dataStore.data.map { preferences ->
        (preferences[uploadCountKey] ?: 0) < freeUploadCount
    }

    suspend fun addShow() {
        dataStore.edit { settings ->
            settings[showCountKey] = (settings[showCountKey] ?: 0) + 1
        }
    }

    suspend fun addUpload() {
        dataStore.edit { settings ->
            settings[uploadCountKey] = (settings[uploadCountKey] ?: 0) + 1
        }
    }

    enum class Status { NotSubscribed, Trial, Subscribed }
}
