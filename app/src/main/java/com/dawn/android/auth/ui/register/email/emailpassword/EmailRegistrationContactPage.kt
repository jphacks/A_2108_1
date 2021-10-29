package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.common.ui.Spinner
import com.dawn.android.ui.LocalNav
import kotlinx.coroutines.flow.collect

@Composable
fun EmailRegistrationContactPage(
    viewModel: EmailRegistrationViewModel,
) {
    val navController = LocalNav.current
    val loading = viewModel.loading.collectAsState().value
    LaunchedEffect(Unit) {
        viewModel.finish.collect { finish ->
            if (finish) {
                navController.navigate(AuthNavItems.RegisterDone.route)
            }
        }
    }
    if (loading) {
        Spinner()
    } else {
        EmailRegistrationContactTemplate(
            onClickBack = {
                navController.popBackStack()
            },
            onClickNext = {
                viewModel.contact(it)
            }
        )
    }
}
