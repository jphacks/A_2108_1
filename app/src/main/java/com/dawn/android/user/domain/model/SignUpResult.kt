package com.dawn.android.user.domain.model

sealed interface SignUpResult {
    object Success : SignUpResult
    data class Failure(val error: Throwable) : SignUpResult
}
