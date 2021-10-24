package com.dawn.android.plan.detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.BookmarkButton
import com.dawn.android.common.ui.CreatorProfileIcon
import com.dawn.android.common.ui.ShareButton
import com.dawn.android.common.ui.TopBar
import com.dawn.android.common.ui.dotFormat
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Typography
import java.time.Instant

@Composable
fun PlanDetailTemplate(
    uiModel: PlanDetailUIModel,
    onClickBack: () -> Unit,
    onClickShare: () -> Unit,
    onClickBookmark: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(
                navigationIcon = {
                    BackNavigationButton(onClick = onClickBack)
                }
            )
        },
    ) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
        ) {
            item {
                Image(
                    painter = rememberImagePainter(data = uiModel.imageUrl),
                    contentDescription = null,
                )
            }
            item {
                Text(
                    text = uiModel.title,
                    style = Typography.h4,
                    color = Gray900,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 16.dp,
                        end = 8.dp,
                    ),
                )
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 24.dp,
                    )
                ) {
                    CreatorProfileIcon(imageUrl = uiModel.creatorProfileImageUrl)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = uiModel.creatorName,
                            style = Typography.body2,
                            color = Gray900,
                        )
                        Text(
                            text = uiModel.createdAt.dotFormat(),
                            style = Typography.body2,
                            color = Gray900,
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 24.dp,
                    )
                ) {
                    ShareButton(onClick = onClickShare)
                    Spacer(modifier = Modifier.width(16.dp))
                    BookmarkButton(
                        bookmarkCount = uiModel.bookmarkCount,
                        bookmarked = uiModel.bookmarked,
                        onClick = onClickBookmark,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PlanDetailPreview() {
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
        places = listOf(),
        seasons = listOf(),
        timeSpans = listOf(),
        cost = 10000,
    )
    DawnTheme {
        PlanDetailTemplate(
            uiModel = uiModel,
            onClickBack = {},
            onClickShare = {},
            onClickBookmark = {},
        )
    }
}
