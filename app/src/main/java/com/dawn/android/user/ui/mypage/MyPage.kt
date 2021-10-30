package com.dawn.android.user.ui.mypage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dawn.android.auth.domain.model.LoginStatus
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.ui.LocalNav

@Composable
fun MyPage(
    viewModel: MyPageViewModel,
) {
    val navController = LocalNav.current
    val loginStatus = viewModel.loginStatus.collectAsState().value
    val me = viewModel.me.collectAsState().value
    when (loginStatus) {
        is LoginStatus.LoggedIn -> {
            if (me != null) {
                MyPageTemplate(me)
            } else {
                viewModel.refreshMe()
            }
        }
        LoginStatus.NotLoggedIn -> {
            GuestTemplate {
                navController.navigate(AuthNavItems.RegisterEntry.route)
            }
        }
    }
}
