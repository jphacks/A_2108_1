package com.dawn.android.plan.detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.Spinner
import com.dawn.android.ui.LocalNav

@Composable
fun PlanDetailPage(
    viewModel: PlanDetailViewModel,
) {
    val navController = LocalNav.current
    val uiModel = viewModel.planDetail.value
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (uiModel != null) {
            PlanDetailTemplate(
                uiModel = uiModel,
                onClickShare = { /*TODO*/ },
                onClickBookmark = { /*TODO*/ },
            )
        } else {
            Spinner()
        }
        Box(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
            )
        ) {
            BackNavigationButton {
                navController.popBackStack()
            }
        }
    }
}
