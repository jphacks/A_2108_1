package com.dawn.android.plan.detail.ui

import androidx.compose.runtime.Composable
import java.time.Instant

@Composable
fun PlanDetailPage(
    planId: Long,
) {
    // TODO: get from api
    val uiModel = PlanDetailUIModel(
        title = "会津塩川花火大会の旅",
        description = "福島県会津の塩川花火を２泊３日でお子さんと楽しめるプランです。 他にも地元の人気店などもご紹介しています",
        imageUrl = "https://news.walkerplus.com/article/1041174/10377956_615.jpg",
        creatorName = "ほげたほげお",
        creatorProfileImageUrl = "https://yt8492.com/icon/yt8492-200.jpg",
        bookmarkCount = 123,
        bookmarked = false,
        days = listOf(),
        createdAt = Instant.now(),
        places = listOf("福島県 会津若松"),
        categories = listOf("風景", "イベント"),
        seasons = listOf("1~3月"),
        timeSpans = listOf("日帰り"),
        cost = 10000,
    )
    PlanDetailTemplate(
        uiModel = uiModel,
        onClickBack = { /*TODO*/ },
        onClickShare = { /*TODO*/ },
        onClickBookmark = { /*TODO*/ },
    )
}
