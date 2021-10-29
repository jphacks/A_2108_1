package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.runtime.Composable
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.ui.LocalNav

@Composable
fun EmailRegistrationEmailPasswordNicknameUserIdPage(
    viewModel: EmailRegistrationViewModel,
) {
    val navController = LocalNav.current
    EmailRegistrationEmailPasswordNicknameUserIdTemplate(
        onClickBack = {
            navController.navigate(AuthNavItems.Area.route)
        },
        onClickNext = viewModel::accountInfo,
    )
}
