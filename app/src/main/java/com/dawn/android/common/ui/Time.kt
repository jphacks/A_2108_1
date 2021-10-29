package com.dawn.android.common.ui

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Instant.dotFormat(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    return OffsetDateTime
        .ofInstant(this, ZoneId.systemDefault())
        .format(formatter)
}

fun LocalTime.colonFormat(): String {
    val formatter = DateTimeFormatter.ofPattern("hh:mm")
    return format(formatter)
}

fun Instant.toRFC3339(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return atZone(ZoneId.systemDefault()).format(formatter)
}

fun LocalDate.toRFC3339(): String {
    return atStartOfDay(ZoneId.systemDefault()).toInstant().toRFC3339()
}
