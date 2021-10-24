package com.dawn.android.plan.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dawn.android.common.ui.TopBar
import com.dawn.android.plan.timeline.ui.TimelineItemUIModel
import com.dawn.android.plan.timeline.ui.TimelineTemplate
import com.dawn.android.plan.timeline.ui.TimelineUIModel
import com.dawn.android.ui.theme.DawnTheme
import java.time.Instant

@Composable
fun HomeTemplate(
    timelineUiModel: TimelineUIModel,
    loading: Boolean,
    refresh: () -> Unit,
    onClickTimelineItem: (TimelineItemUIModel) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(title = "タイムライン")
        }
    ) {
        TimelineTemplate(
            uiModel = timelineUiModel,
            loading = loading,
            refresh = refresh,
            onClickItem = onClickTimelineItem,
        )
    }
}

@Composable
@Preview
fun HomePreview() {
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
    DawnTheme {
        Scaffold {
            HomeTemplate(
                timelineUiModel = uiModel,
                loading = false,
                refresh = {},
                onClickTimelineItem = {},
            )
        }
    }
}
