package com.dawn.android.user.domain.service

import com.dawn.android.user.domain.model.Token

interface TokenProvider {
    suspend fun provide(): Token?
}
