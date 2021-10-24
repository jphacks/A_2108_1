package com.dawn.android.plan.detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import com.dawn.android.ui.theme.MainColor
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White
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
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                BoxWithConstraints(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = uiModel.imageUrl,
                            builder = {
                                size(
                                    width = constraints.maxWidth,
                                    100, // 暫定
                                )
                            },
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Text(
                    text = uiModel.title,
                    style = Typography.h4,
                    color = Gray900,
                    modifier = Modifier.padding(
                        horizontal = 8.dp,
                    ),
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        start = 8.dp,
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
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        start = 16.dp,
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
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MainColor,
                        ),
                ) {
                    Spacer(modifier = Modifier.height(56.dp))
                    Text(
                        text = "概要",
                        style = Typography.h4,
                        color = Gray900,
                        modifier = Modifier.padding(
                            start = 16.dp,
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .background(
                                color = White,
                                shape = Shapes.medium,
                            )
                            .padding(
                                vertical = 16.dp,
                                horizontal = 8.dp,
                            ),
                    ) {
                        PlanAbstractInfoRow(
                            title = "場所",
                            value = uiModel.places.joinToString("、"),
                        )
                        PlanAbstractInfoRow(
                            title = "カテゴリ",
                            value = uiModel.categories.joinToString("、"),
                        )
                        PlanAbstractInfoRow(
                            title = "時期",
                            value = uiModel.seasons.joinToString("、"),
                        )
                        PlanAbstractInfoRow(
                            title = "期間",
                            value = uiModel.timeSpans.joinToString("、"),
                        )
                        PlanAbstractInfoRow(
                            title = "料金",
                            value = "%,d円".format(uiModel.cost),
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = uiModel.description,
                            style = Typography.body1,
                            color = Gray900,
                        )
                    }
                    Spacer(modifier = Modifier.height(56.dp))
                }
            }
        }
    }
}

@Composable
fun PlanAbstractInfoRow(
    title: String,
    value: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(30.dp)
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(
                    color = MainColor,
                    shape = CircleShape
                ),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = Typography.h6,
            color = Gray900,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = value,
            style = Typography.body1,
            color = Gray900,
        )
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
        places = listOf("福島県 会津若松"),
        categories = listOf("風景", "イベント"),
        seasons = listOf("1~3月"),
        timeSpans = listOf("日帰り"),
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
