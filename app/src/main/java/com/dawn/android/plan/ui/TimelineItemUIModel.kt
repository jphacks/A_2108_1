package com.dawn.android.plan.ui

import java.time.Instant

data class TimelineItemUIModel(
    val title: String,
    val planImageUrl: String,
    val bookmarks: Int,
    val creatorName: String,
    val creatorProfileImageUrl: String,
    val creatorJob: String,
    val creatorJobExperienceYears: Int,
    val createdAt: Instant,
)
