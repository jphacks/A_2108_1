package com.dawn.android.auth.ui

sealed class AuthNavItems(val route: String) {
    object RegisterEntry : AuthNavItems("RegisterEntry")
    object AccountInfo : AuthNavItems("AccountInfo")
    object Area : AuthNavItems("Area")
    object Prefecture : AuthNavItems("Prefecture")
    object City : AuthNavItems("City")
    object Biography : AuthNavItems("Biography")
    object Contact : AuthNavItems("Contact")
    object RegisterDone : AuthNavItems("RegisterDone")

    sealed class Login(route: String) : AuthNavItems(route) {
        object Entry : Login("LoginEntry")
        object EmailPassword : Login("LoginEmailPassword")
    }
}
