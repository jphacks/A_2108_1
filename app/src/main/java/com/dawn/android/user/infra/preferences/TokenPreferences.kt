package com.dawn.android.user.infra.preferences

import android.content.Context
import androidx.core.content.edit
import com.dawn.android.common.infra.preferences.Preferences

class TokenPreferences(
    context: Context,
) : Preferences(NAME, context) {
    companion object {
        private const val NAME = "TokenPreferences"
        private const val KEY_TOKEN = "key_token"
    }

    fun putToken(token: String) {
        pref.edit {
            putString(KEY_TOKEN, token)
        }
    }

    fun getToken(): String? {
        return pref.getString(KEY_TOKEN, null)
    }

    fun delete() {
        pref.edit {
            clear()
        }
    }
}