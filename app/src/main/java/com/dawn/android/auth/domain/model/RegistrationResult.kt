package com.dawn.android.auth.domain.model

sealed interface RegistrationResult {
    data class Success(val token: Token) : RegistrationResult
    data class Failure(val error: Throwable) : RegistrationResult
}
