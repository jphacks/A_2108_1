package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.ui.LocalNav

@Composable
fun EmailRegistrationAreaPage(
    viewModel: EmailRegistrationViewModel,
) {
    val navController = LocalNav.current
    val areas = viewModel.areas.collectAsState().value
    EmailRegistrationAreaTemplate(
        areas = areas,
        onClickBack = {
            navController.popBackStack()
        },
        onClickArea = { area ->
            viewModel.area(area)
            navController.navigate(AuthNavItems.Prefecture.route)
        }
    )
}
