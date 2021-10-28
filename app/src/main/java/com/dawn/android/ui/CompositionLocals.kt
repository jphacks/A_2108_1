package com.dawn.android.ui

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNav = staticCompositionLocalOf<NavHostController> {
    error("No NavHostController provided")
}
