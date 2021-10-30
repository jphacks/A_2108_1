package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.ui.LocalNav

@Composable
fun EmailRegistrationCityPage(
    viewModel: EmailRegistrationViewModel,
) {
    val navController = LocalNav.current
    val state = viewModel.currentState.collectAsState().value
    val area = state.area ?: return
    val prefecture = state.prefecture ?: return
    val cities = viewModel.cities.collectAsState().value
    EmailRegistrationCityTemplate(
        area = area,
        prefecture = prefecture,
        cities = cities,
        onClickBack = {
            navController.popBackStack()
        },
        onClickNext = { city ->
            viewModel.city(city)
            navController.navigate(AuthNavItems.Biography.route)
        }
    )
}
