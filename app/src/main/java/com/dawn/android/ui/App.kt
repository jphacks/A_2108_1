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
import com.dawn.android.plan.detail.ui.PlanDetailPage
import com.dawn.android.plan.detail.ui.PlanDetailViewModel
import com.dawn.android.plan.ui.HomePage
import com.dawn.android.plan.ui.PlanNavItems
import com.dawn.android.ui.theme.White
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
                    HomePage()
                }
                composable(route = PlanNavItems.PlanDetail.route + "/{${PlanNavItems.PlanDetail.planIdArg}}") { backStackEntry ->
                    val id = requireNotNull(backStackEntry.arguments?.getString(PlanNavItems.PlanDetail.planIdArg)).toLong()
                    val viewModel = getViewModel<PlanDetailViewModel> {
                        parametersOf(id)
                    }
                    PlanDetailPage(viewModel)
                }
            }
        }
    }
}
