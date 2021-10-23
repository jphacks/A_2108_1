package com.dawn.android.common.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 24.dp,
                )
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        backgroundColor = BackgroundColor,
        elevation = 0.dp,
        modifier = Modifier.height(80.dp),
    )
}
