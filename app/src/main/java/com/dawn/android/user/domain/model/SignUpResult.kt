package com.dawn.android.user.domain.model

sealed interface SignUpResult {
    data class Success(val token: Token) : SignUpResult
    data class Failure(val error: Throwable) : SignUpResult
}
