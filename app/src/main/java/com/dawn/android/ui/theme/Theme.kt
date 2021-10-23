package com.dawn.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val ColorPalette = lightColors(
    primary = Gray900,
    primaryVariant = Gray700,
    secondary = MainColor,
    secondaryVariant = SubMainColor,
    error = AccentRed,
)

@Composable
fun DawnTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}