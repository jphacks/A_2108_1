package com.dawn.android.user.infra.impl.domain.service

import android.content.SharedPreferences
import com.dawn.android.user.domain.model.Token
import com.dawn.android.user.domain.service.TokenProvider

class TokenProviderImpl(
    private val preferences: SharedPreferences,
) : TokenProvider {
    companion object {
        private const val KEY_TOKEN = "key_token"
    }

    override suspend fun provide(): Token? {
        val rawToken = preferences.getString(KEY_TOKEN, null) ?: return null
        return Token(rawToken)
    }
}