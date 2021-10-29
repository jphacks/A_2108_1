package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.ui.LocalNav

@Composable
fun EmailRegistrationPrefecturePage(
    viewModel: EmailRegistrationViewModel,
) {
    val navController = LocalNav.current
    val state = viewModel.currentState.collectAsState().value
    val prefectures = viewModel.prefectures.collectAsState().value
    EmailRegistrationPrefectureTemplate(
        area = state.area ?: return,
        prefectures = prefectures,
        onClickBack = {
            navController.popBackStack()
        },
        onClickPrefecture = { prefecture ->
            viewModel.prefecture(prefecture)
            navController.navigate(AuthNavItems.City.route)
        }
    )
}
