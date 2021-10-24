package com.dawn.android.common.ui

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Instant.dotFormat(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    return OffsetDateTime
        .ofInstant(this, ZoneId.systemDefault())
        .format(formatter)
}