package com.dawn.android.auth.domain.service

import com.dawn.android.auth.domain.model.Token

interface TokenProvider {
    suspend fun provide(): Token?
    suspend fun save(token: Token)
    suspend fun delete()
}
