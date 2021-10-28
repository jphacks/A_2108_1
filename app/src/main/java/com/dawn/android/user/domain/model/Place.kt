package com.dawn.android.user.domain.model

import com.dawn.android.plan.domain.model.PlaceId

data class Place(
    val id: PlaceId,
    val area: Int,
    val prefecture: Int,
    val city: Int,
    val name: String,
)
