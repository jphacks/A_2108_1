package com.dawn.android.plan.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.dawn.android.plan.timeline.ui.TimelineUIModel
import com.dawn.android.ui.LocalNav

@Composable
fun HomePage(
    viewModel: HomeViewModel,
) {
    LaunchedEffect(Unit) {
        viewModel.refresh()
    }
    val navController = LocalNav.current
    val items = viewModel.timelineItems.collectAsState().value
    val uiModel = TimelineUIModel(
        items = items,
    )
    val loading = viewModel.loading.collectAsState().value
    HomeTemplate(
        timelineUiModel = uiModel,
        loading = loading,
        refresh = viewModel::refresh,
        onClickTimelineItem = {
            navController.navigate(
                route = PlanNavItems.PlanDetail.route + "/${it.id}"
            )
        }
    )
}
