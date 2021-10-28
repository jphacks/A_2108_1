package com.dawn.android.common.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.ui.theme.BackgroundColor
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White

@Composable
fun TopBar(
    title: String? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        backgroundColor = BackgroundColor,
        elevation = 0.dp,
        modifier = Modifier.height(80.dp),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 30.dp,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (navigationIcon != null) {
                navigationIcon()
                Spacer(modifier = Modifier.width(16.dp))
            }
            if (title != null) {
                Text(
                    text = title,
                    style = Typography.h4,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            actions()
        }
    }
}

@Composable
@Preview
fun TopBarPreview() {
    Scaffold(
        topBar = {
            TopBar(
                title = "タイトル",
                navigationIcon = {
                    BackNavigationButton {}
                }
            )
        },
        backgroundColor = White
    ) {

    }
}
