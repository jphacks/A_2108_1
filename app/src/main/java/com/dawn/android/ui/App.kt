package com.dawn.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dawn.android.auth.ui.AuthNavItems
import com.dawn.android.auth.ui.register.RegisterEntryPage
import com.dawn.android.auth.ui.register.email.EmailRegistrationViewModel
import com.dawn.android.auth.ui.register.email.emailpassword.EmailRegistrationEmailPasswordNicknameUserIdPage
import com.dawn.android.common.di.routeViewModel
import com.dawn.android.plan.detail.ui.PlanDetailPage
import com.dawn.android.plan.detail.ui.PlanDetailViewModel
import com.dawn.android.plan.domain.model.PlanId
import com.dawn.android.plan.ui.HomePage
import com.dawn.android.plan.ui.HomeViewModel
import com.dawn.android.plan.ui.PlanNavItems
import com.dawn.android.ui.theme.White
import com.dawn.android.user.ui.mypage.MyPage
import com.dawn.android.user.ui.mypage.MyPageViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun App() {
    val navController = rememberNavController()
    CompositionLocalProvider(
        LocalNav provides navController,
    ) {
        AppContent()
    }
}

@Composable
fun AppContent() {
    val navController = LocalNav.current
    Scaffold(
        bottomBar = {
            AppBottomNavigation()
        },
        backgroundColor = White,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomNavItems.Home.route,
            ) {
                composable(route = BottomNavItems.Home.route) {
                    val viewModel = getViewModel<HomeViewModel>()
                    HomePage(viewModel)
                }
                composable(route = BottomNavItems.MyPage.route) {
                    val viewModel = getViewModel<MyPageViewModel>()
                    MyPage(viewModel)
                }
                composable(route = PlanNavItems.PlanDetail.route + "/{${PlanNavItems.PlanDetail.planIdArg}}") { backStackEntry ->
                    val rawId = requireNotNull(backStackEntry.arguments?.getString(PlanNavItems.PlanDetail.planIdArg)).toLong()
                    val id = PlanId(rawId)
                    val viewModel = getViewModel<PlanDetailViewModel> {
                        parametersOf(id)
                    }
                    PlanDetailPage(viewModel)
                }
                composable(route = AuthNavItems.RegisterEntry.route) {
                    RegisterEntryPage()
                }
                composable(route = AuthNavItems.AccountInfo.route) {
                    val viewModel = navController.routeViewModel<EmailRegistrationViewModel>()
                    EmailRegistrationEmailPasswordNicknameUserIdPage(viewModel)
                }
            }
        }
    }
}
