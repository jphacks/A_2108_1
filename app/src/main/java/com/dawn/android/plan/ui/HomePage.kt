package com.dawn.android.plan.ui

import androidx.compose.runtime.Composable
import com.dawn.android.plan.timeline.ui.TimelineItemUIModel
import com.dawn.android.plan.timeline.ui.TimelineUIModel
import com.dawn.android.ui.LocalNav
import java.time.Instant

@Composable
fun HomePage() {
    val navController = LocalNav.current
    // TODO: get from api
    val uiModel = TimelineUIModel(
        items = List(3) {
            TimelineItemUIModel(
                id = 0,
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
    HomeTemplate(
        timelineUiModel = uiModel,
        loading = false,
        refresh = {},
        onClickTimelineItem = {
            navController.navigate(
                route = PlanNavItems.PlanDetail.route + "/${it.id}"
            )
        }
    )
}
