package com.dawn.android.auth.infra.impl.domain.service

import com.dawn.android.auth.domain.model.Token
import com.dawn.android.auth.domain.service.TokenProvider
import com.dawn.android.auth.infra.preferences.TokenPreferences

class TokenProviderImpl(
    private val preferences: TokenPreferences,
) : TokenProvider {
    override suspend fun provide(): Token? {
        val rawToken = preferences.getToken() ?: return null
        return Token(rawToken)
    }

    override suspend fun save(token: Token) {
        preferences.putToken(token.value)
    }

    override suspend fun delete() {
        preferences.delete()
    }
}