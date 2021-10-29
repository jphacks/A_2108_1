package com.dawn.android.auth.ui

sealed class AuthNavItems(val route: String) {
    object RegisterEntry : AuthNavItems("RegisterEntry")
}
