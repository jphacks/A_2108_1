package com.dawn.android.auth.domain.model

sealed interface LoginStatus {
    data class LoggedIn(val token: Token) : LoginStatus
    object NotLoggedIn : LoginStatus
}
