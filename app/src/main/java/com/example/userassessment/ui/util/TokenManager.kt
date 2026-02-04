package com.example.userassessment.ui.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.authDataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_prefs")

@Singleton
class TokenManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val dataStore = context.authDataStore

    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
    }

    val accessToken: Flow<String?> = dataStore.data.map { preferences ->
        preferences[ACCESS_TOKEN]
    }

    suspend fun saveTokens(access: String) {
        dataStore.edit {
            it[ACCESS_TOKEN] = access
        }
    }

    suspend fun getAccessTokenBlocking(): String? = dataStore.data.first()[ACCESS_TOKEN]


    suspend fun clearTokens() = dataStore.edit {
        it.clear()
        println("Token berhasil dihapus dari DataStore")
    }
}