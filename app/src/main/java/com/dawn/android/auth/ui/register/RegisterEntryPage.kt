package com.dawn.android.auth.ui.register

import androidx.compose.runtime.Composable
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.ui.LocalNav

@Composable
fun RegisterEntryPage() {
    val navController = LocalNav.current
    RegisterEntryTemplate {
        navController.navigate(AuthNavItems.AccountInfo.route)
    }
}
