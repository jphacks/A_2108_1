package com.dawn.android.plan.detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.ui.LocalNav
import java.time.Instant
import java.time.LocalTime

@Composable
fun PlanDetailPage(
    planId: Long,
) {
    val navController = LocalNav.current
    // TODO: get from api
    val uiModel = PlanDetailUIModel(
        title = "会津塩川花火大会の旅",
        description = "福島県会津の塩川花火を２泊３日でお子さんと楽しめるプランです。 他にも地元の人気店などもご紹介しています",
        imageUrl = "https://news.walkerplus.com/article/1041174/10377956_615.jpg",
        creatorName = "ほげたほげお",
        creatorProfileImageUrl = "https://yt8492.com/icon/yt8492-200.jpg",
        bookmarkCount = 123,
        bookmarked = false,
        schedule = listOf(
            PlanScheduleUIModel.Day(1),
            PlanScheduleUIModel.Heading(
                text = "会津に向かう",
            )
        ) + List(4) {
            PlanScheduleUIModel.Section(
                title = "自宅から会津まで車で移動",
                description = "地元の人だと会津若松駅からのスタートだと思います。\n" +
                    "会津若松駅は下のリンクから。\n" +
                    "注意としては５番線の位置が若干わかりづらいです。\n" +
                    "列車３番線から降りたらすぐに右側に回り、赤い「５番線へ」という看板を目印にするといいと思います",
                startTime = LocalTime.of(10, 0),
                endTime = LocalTime.of(12, 0),
            )
        } + PlanScheduleUIModel.Heading(
            text = "会津に向かう",
        ) + List(3) {
            PlanScheduleUIModel.Section(
                title = "自宅から会津まで車で移動",
                description = "地元の人だと会津若松駅からのスタートだと思います。\n" +
                    "会津若松駅は下のリンクから。\n" +
                    "注意としては５番線の位置が若干わかりづらいです。\n" +
                    "列車３番線から降りたらすぐに右側に回り、赤い「５番線へ」という看板を目印にするといいと思います",
                startTime = LocalTime.of(10, 0),
                endTime = LocalTime.of(12, 0),
            )
        } + listOf(
            PlanScheduleUIModel.Day(2),
            PlanScheduleUIModel.Heading(
                text = "会津に向かう",
            )
        ) +  List(3) {
            PlanScheduleUIModel.Section(
                title = "自宅から会津まで車で移動",
                description = "地元の人だと会津若松駅からのスタートだと思います。\n" +
                    "会津若松駅は下のリンクから。\n" +
                    "注意としては５番線の位置が若干わかりづらいです。\n" +
                    "列車３番線から降りたらすぐに右側に回り、赤い「５番線へ」という看板を目印にするといいと思います",
                startTime = LocalTime.of(10, 0),
                endTime = LocalTime.of(12, 0),
            )
        },
        createdAt = Instant.now(),
        places = listOf("福島県 会津若松"),
        categories = listOf("風景", "イベント"),
        seasons = listOf("1~3月"),
        timeSpans = listOf("日帰り"),
        cost = 10000,
    )
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        PlanDetailTemplate(
            uiModel = uiModel,
            onClickShare = { /*TODO*/ },
            onClickBookmark = { /*TODO*/ },
        )
        Box(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
            )
        ) {
            BackNavigationButton {
                navController.popBackStack()
            }
        }
    }
}
