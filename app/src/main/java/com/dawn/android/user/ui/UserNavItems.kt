package com.dawn.android.user.ui

sealed class UserNavItems(val route: String) {
    object CheckLoginStatus : UserNavItems("CheckLoginStatus")
    object Guest : UserNavItems("Guest")
}
