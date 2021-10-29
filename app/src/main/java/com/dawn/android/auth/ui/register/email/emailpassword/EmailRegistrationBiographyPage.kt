package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.runtime.Composable
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.ui.LocalNav

@Composable
fun EmailRegistrationBiographyPage(
    viewModel: EmailRegistrationViewModel,
) {
    val navController = LocalNav.current
    EmailRegistrationBiographyTemplate(
        onClickBack = {
            navController.popBackStack()
        },
        onClickNext = {
            viewModel.biography(it)
            navController.navigate(AuthNavItems.Contact.route)
        }
    )
}
