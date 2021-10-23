package com.dawn.android.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // o/logo
    h1 = TextStyle(
        fontSize = 23.sp,
        fontWeight = FontWeight.W900,
        lineHeight = 46.sp,
        letterSpacing = 8.05.sp,
    ),
    // h/section
    h4 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.W900,
        lineHeight = 33.6.sp,
    ),
    // h/sub-section
    h5 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 30.sp,
    ),
    // h/small
    h6 = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 22.5.sp,
    ),
    // p/normal
    body1 = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 30.sp,
    ),
    // p/small
    body2 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 21.sp,
    ),
    // o/card
    subtitle1 = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 22.5.sp,
    ),
    // o/event-explain
    subtitle2 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp,
    ),
    // o/yen
    caption = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.5.sp,
    ),
)
