package com.dawn.android.auth.ui.login.email

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.dawn.android.ui.BottomNavItems
import com.dawn.android.ui.LocalNav
import kotlinx.coroutines.flow.collect

@Composable
fun EmailLoginPage(
    viewModel: EmailLoginViewModel,
) {
    val navController = LocalNav.current
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.finish.collect {
            if (it) {
                navController.navigate(BottomNavItems.MyPage.route)
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.message.collect {
            it ?: return@collect
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
    val loading = viewModel.loading.collectAsState().value
    EmailLoginTemplate(
        loading = loading,
        onBackPressed = {
            navController.popBackStack()
        },
        onClickLogin = { email, password ->
            viewModel.login(email, password)
        }
    )
}
