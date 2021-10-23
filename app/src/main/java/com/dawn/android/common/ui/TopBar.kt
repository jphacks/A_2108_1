package com.dawn.android.common.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dawn.android.ui.theme.BackgroundColor
import com.dawn.android.ui.theme.Typography

@Composable
fun TopBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = Typography.h4,
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        backgroundColor = BackgroundColor,
        elevation = 0.dp
    )
}
