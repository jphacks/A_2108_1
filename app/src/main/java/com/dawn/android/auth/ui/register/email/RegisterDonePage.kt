package com.dawn.android.auth.ui.register.email

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.dawn.android.auth.ui.register.RegisterDoneTemplate
import com.dawn.android.ui.BottomNavItems
import com.dawn.android.ui.LocalNav

@Composable
fun RegisterDonePage() {
    val navController = LocalNav.current
    BackHandler {
        navController.navigate(BottomNavItems.Home.route)
    }
    RegisterDoneTemplate {
        navController.navigate(BottomNavItems.Home.route)
    }
}
