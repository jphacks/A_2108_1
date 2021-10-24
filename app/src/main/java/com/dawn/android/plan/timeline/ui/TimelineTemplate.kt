package com.dawn.android.plan.timeline.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray500
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.SubMainColor
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun TimelineTemplate(
    uiModel: TimelineUIModel,
    loading: Boolean,
    refresh: () -> Unit,
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = loading),
        onRefresh = { refresh() }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(uiModel.items) { item ->
                TimelineItem(uiModel = item)
            }
        }
    }
}

@Composable
fun TimelineItem(
    uiModel: TimelineItemUIModel,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(3.dp, Shapes.small),
    ) {
        Row(
            modifier = Modifier
                .background(
                    color = White,
                    shape = Shapes.small,
                )
                .padding(8.dp)
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
                val createdAtText = OffsetDateTime.ofInstant(uiModel.createdAt, ZoneId.systemDefault())
                    .format(formatter)
                Text(
                    text = createdAtText,
                    style = Typography.body2,
                    color = Gray500,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = uiModel.title,
                    style = Typography.subtitle1,
                    color = Gray900,
                    maxLines = 2,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = rememberImagePainter(data = uiModel.creatorProfileImageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape),
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = uiModel.creatorName,
                        style = Typography.body2,
                        color = Gray900,
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                val creatorJobText = "%s - %d年".format(uiModel.creatorJob, uiModel.creatorJobExperienceYears)
                Text(
                    text = creatorJobText,
                    style = Typography.body2,
                    color = Gray900,
                    modifier = Modifier
                        .background(
                            color = SubMainColor,
                            shape = Shapes.small,
                        )
                        .padding(horizontal = 8.dp),
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.BookmarkBorder,
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = uiModel.bookmarks.toString(),
                        style = Typography.body2,
                        color = Gray900,
                    )
                }
            }
            Image(
                painter = rememberImagePainter(data = uiModel.planImageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        width = 81.dp,
                        height = 144.dp,
                    )
                    .clip(Shapes.small),
            )
        }
    }
}

@Composable
@Preview
fun TimelinePreview() {
    DawnTheme {
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
        Scaffold(
            backgroundColor = White
        ) {
            TimelineTemplate(uiModel = uiModel, loading = false) {

            }
        }
    }
}
