package com.dawn.android.plan.domain.model

data class Place(
    val id: PlaceId,
    val area: String,
    val prefecture: String?,
    val city: String?,
)
