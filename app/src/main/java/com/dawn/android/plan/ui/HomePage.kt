package com.dawn.android.plan.ui

import androidx.compose.runtime.Composable
import java.time.Instant

@Composable
fun HomePage() {
    // TODO: get from api
    val uiModel = TimelineUIModel(
        items = List(3) {
            TimelineItemUIModel(
                title = "会津若松の旅２泊３道の温泉旅、福島県でいい旅をしよう",
                planImageUrl = "https://news.walkerplus.com/article/1041174/10377956_615.jpg",
                bookmarks = 123,
                creatorName = "ほげたほげお",
                creatorProfileImageUrl = "https://yt8492.com/icon/yt8492-200.jpg",
                creatorJob = "旅館スタッフ",
                creatorJobExperienceYears = 12,
                createdAt = Instant.now(),
            )
        }
    )
    HomeTemplate(timelineUiModel = uiModel, loading = false) {

    }
}
