package com.dawn.android.auth.ui.login

import androidx.compose.runtime.Composable
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.ui.LocalNav

@Composable
fun LoginEntryPage() {
    val navController = LocalNav.current
    LoginEntryTemplate(
        onClickBack = {
            navController.popBackStack()
        },
        onClickEmailLogin = {
            navController.navigate(AuthNavItems.Login.EmailPassword.route)
        },
    )
}
