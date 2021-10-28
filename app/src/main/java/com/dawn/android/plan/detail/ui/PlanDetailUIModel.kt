package com.dawn.android.plan.detail.ui

import java.time.Instant

data class PlanDetailUIModel(
    val title: String,
    val description: String,
    val imageUrl: String,
    val creatorName: String,
    val creatorProfileImageUrl: String,
    val bookmarkCount: Int,
    val bookmarked: Boolean,
    val schedule: List<PlanScheduleUIModel>,
    val createdAt: Instant,
    val places: List<String>,
    val categories: List<String>,
    val seasons: List<String>,
    val timeSpans: List<String>,
    val cost: Int,
)
