package com.dawn.android.plan.detail.ui

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dawn.android.R
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.BookmarkButton
import com.dawn.android.common.ui.CreatorProfileIcon
import com.dawn.android.common.ui.ShareButton
import com.dawn.android.common.ui.colonFormat
import com.dawn.android.common.ui.dotFormat
import com.dawn.android.ui.theme.AccentBlue
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray200
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.MainColor
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White
import java.time.Duration
import java.time.Instant
import java.time.LocalTime

@Composable
fun PlanDetailTemplate(
    uiModel: PlanDetailUIModel,
    onClickShare: () -> Unit,
    onClickBookmark: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
            item {
                Image(
                    painter = rememberImagePainter(
                        data = uiModel.imageUrl,
                        builder = {
                            size(360)
                            placeholder(R.drawable.placeholder)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                )
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
                PlanAbstractSection(uiModel = uiModel)
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(68.dp)
                        .background(Gray200)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "??????????????????",
                        style = Typography.h4,
                        color = Gray900,
                        modifier = Modifier.padding(
                            start = 8.dp,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            items(uiModel.schedule) { schedule ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Gray200),
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    when (schedule) {
                        is PlanScheduleUIModel.Day -> {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                PlanDayHeader(
                                    day = schedule.day,
                                    color = White,
                                )
                            }
                        }
                        is PlanScheduleUIModel.Heading -> {
                            PlanHeading(heading = schedule)
                        }
                        is PlanScheduleUIModel.Section -> {
                            PlanScheduleSection(
                                section = schedule,
                                type = PlanScheduleViewType.Time,
                            )
                        }
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(White)
                        .background(
                            color = Gray200,
                            shape = RoundedCornerShape(
                                bottomStart = 64.dp,
                                bottomEnd = 64.dp,
                            )
                        ),
                )
            }
            item {
                Spacer(modifier = Modifier.height(56.dp))
            }
            item {
                Text(
                    text = "??????????????????",
                    style = Typography.h4,
                    color = Gray900,
                    modifier = Modifier.padding(16.dp),
                )
            }
            items(uiModel.schedule) { schedule ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    when (schedule) {
                        is PlanScheduleUIModel.Day -> {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                PlanDayHeader(
                                    day = schedule.day,
                                    color = Gray200,
                                )
                            }
                        }
                        is PlanScheduleUIModel.Heading -> {
                            PlanHeading(heading = schedule)
                        }
                        is PlanScheduleUIModel.Section -> {
                            PlanScheduleDetailSection(
                                section = schedule,
                                type = PlanScheduleViewType.Time,
                            )
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun PlanAbstractSection(
    uiModel: PlanDetailUIModel,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MainColor,
            ),
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        Text(
            text = "??????",
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
                title = "??????",
                value = uiModel.places.joinToString("???"),
            )
            PlanAbstractInfoRow(
                title = "????????????",
                value = uiModel.categories.joinToString("???"),
            )
            PlanAbstractInfoRow(
                title = "??????",
                value = uiModel.seasons.joinToString("???"),
            )
            PlanAbstractInfoRow(
                title = "??????",
                value = uiModel.timeSpans.joinToString("???"),
            )
            PlanAbstractInfoRow(
                title = "??????",
                value = "%,d???".format(uiModel.cost),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = uiModel.description,
                style = Typography.body1,
                color = Gray900,
            )
        }
        Spacer(modifier = Modifier.height(56.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = Gray200,
                    shape = RoundedCornerShape(
                        topStart = 64.dp,
                        topEnd = 64.dp,
                    )
                ),
        )
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
fun PlanDayHeader(
    day: Int,
    color: Color,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(64.dp)
            .background(
                color = color,
                shape = CircleShape,
            ),
    ) {
        Text(
            text = "%d??????".format(day),
            style = Typography.h6,
            color = Gray900,
        )
    }
}

@Composable
fun PlanHeading(
    heading: PlanScheduleUIModel.Heading,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
                .height(1.dp)
                .background(Gray700),
        )
        Text(
            text = heading.text,
            style = Typography.h6,
            color = Gray700,
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
                .height(1.dp)
                .background(Gray700),
        )
    }
}

enum class PlanScheduleViewType {
    StartEnd,
    Time,
    StartEndTime,
    Map;
}

@Composable
fun PlanScheduleSection(
    section: PlanScheduleUIModel.Section,
    type: PlanScheduleViewType,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        Row {
            PlanScheduleSectionNumber(number = section.number)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = section.title,
                style = Typography.body1,
                color = Gray900,
            )
        }
        when (type) {
            PlanScheduleViewType.StartEnd -> {
                val text = "${section.startTime.colonFormat()} ~ ${section.endTime.colonFormat()}"
                Text(
                    text = text,
                    style = Typography.body2,
                    color = AccentBlue,
                    modifier = Modifier
                        .padding(start = 32.dp),
                )
            }
            PlanScheduleViewType.Time -> {
                val duration = Duration.between(section.startTime, section.endTime)
                val hours = duration.toHours()
                val minutes = duration.toMinutes() % 60
                val text = when {
                    hours == 0L && minutes == 0L -> "0???"
                    hours == 0L -> "${minutes}???"
                    minutes == 0L -> "${hours}??????"
                    else -> "${hours}??????${minutes}???"
                }
                Text(
                    text = text,
                    style = Typography.body2,
                    color = AccentBlue,
                    modifier = Modifier
                        .padding(start = 44.dp),
                )
            }
            PlanScheduleViewType.StartEndTime -> {
                Row(
                    modifier = Modifier.padding(start = 32.dp)
                ) {
                    val startEndTime = "${section.startTime.colonFormat()} ~ ${section.endTime.colonFormat()}"
                    Text(
                        text = startEndTime,
                        style = Typography.body2,
                        color = AccentBlue,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    val duration = Duration.between(section.startTime, section.endTime)
                    val hours = duration.toHours()
                    val minutes = duration.toMinutes() % 60
                    val durationText = when {
                        hours == 0L && minutes == 0L -> "0???"
                        hours == 0L -> "${minutes}???"
                        minutes == 0L -> "${hours}??????"
                        else -> "${hours}??????${minutes}???"
                    }
                    Text(
                        text = durationText,
                        style = Typography.body2,
                        color = AccentBlue,
                    )
                }
            }
            PlanScheduleViewType.Map -> {
                Text(text = "??????????????????")
            }
        }
    }
}

@Composable
fun PlanScheduleDetailSection(
    section: PlanScheduleUIModel.Section,
    type: PlanScheduleViewType,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PlanScheduleSectionNumber(number = section.number)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = section.title,
                style = Typography.h5,
                color = Gray900,
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        when (type) {
            PlanScheduleViewType.StartEnd -> {
                val text = "${section.startTime.colonFormat()} ~ ${section.endTime.colonFormat()}"
                Text(
                    text = text,
                    style = Typography.body2,
                    color = AccentBlue,
                    modifier = Modifier
                        .padding(start = 32.dp),
                )
            }
            PlanScheduleViewType.Time -> {
                val duration = Duration.between(section.startTime, section.endTime)
                val hours = duration.toHours()
                val minutes = duration.toMinutes() % 60
                val text = when {
                    hours == 0L && minutes == 0L -> "0???"
                    hours == 0L -> "${minutes}???"
                    minutes == 0L -> "${hours}??????"
                    else -> "${hours}??????${minutes}???"
                }
                Text(
                    text = text,
                    style = Typography.body2,
                    color = AccentBlue,
                    modifier = Modifier
                        .padding(start = 44.dp),
                )
            }
            PlanScheduleViewType.StartEndTime -> {
                Row(
                    modifier = Modifier.padding(start = 32.dp)
                ) {
                    val startEndTime = "${section.startTime.colonFormat()} ~ ${section.endTime.colonFormat()}"
                    Text(
                        text = startEndTime,
                        style = Typography.body2,
                        color = AccentBlue,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    val duration = Duration.between(section.startTime, section.endTime)
                    val hours = duration.toHours()
                    val minutes = duration.toMinutes() % 60
                    val durationText = when {
                        hours == 0L && minutes == 0L -> "0???"
                        hours == 0L -> "${minutes}???"
                        minutes == 0L -> "${hours}??????"
                        else -> "${hours}??????${minutes}???"
                    }
                    Text(
                        text = durationText,
                        style = Typography.body2,
                        color = AccentBlue,
                    )
                }
            }
            PlanScheduleViewType.Map -> {
                Text(text = "??????????????????")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = section.description,
            style = Typography.subtitle2,
            color = Gray900,
        )
    }
}

@Composable
fun PlanScheduleSectionNumber(
    number: Int,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(24.dp)
            .background(
                color = MainColor,
                shape = CircleShape,
            ),
    ) {
        Text(
            text = number.toString(),
            style = Typography.h6,
            color = Gray900,
        )
    }
}

@Composable
@Preview
fun PlanDetailPreview() {
    val uiModel = PlanDetailUIModel(
        title = "??????????????????????????????",
        description = "????????????????????????????????????????????????????????????????????????????????????????????? ????????????????????????????????????????????????????????????",
        imageUrl = "https://news.walkerplus.com/article/1041174/10377956_615.jpg",
        creatorName = "??????????????????",
        creatorProfileImageUrl = "https://yt8492.com/icon/yt8492-200.jpg",
        bookmarkCount = 123,
        bookmarked = false,
        schedule = listOf(
            PlanScheduleUIModel.Day(1),
            PlanScheduleUIModel.Heading(
                text = "??????????????????",
            )
        ) + List(4) {
            PlanScheduleUIModel.Section(
                number = it + 1,
                title = "????????????????????????????????????",
                description = "???????????????????????????????????????????????????????????????????????????\n" +
                    "??????????????????????????????????????????\n" +
                    "????????????????????????????????????????????????????????????????????????\n" +
                    "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
                startTime = LocalTime.of(10, 0),
                endTime = LocalTime.of(12, 0),
            )
        } + PlanScheduleUIModel.Heading(
            text = "??????????????????",
        ) + List(3) {
            PlanScheduleUIModel.Section(
                number = it + 5,
                title = "????????????????????????????????????",
                description = "???????????????????????????????????????????????????????????????????????????\n" +
                    "??????????????????????????????????????????\n" +
                    "????????????????????????????????????????????????????????????????????????\n" +
                    "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
                startTime = LocalTime.of(10, 0),
                endTime = LocalTime.of(12, 0),
            )
        } + listOf(
            PlanScheduleUIModel.Day(2),
            PlanScheduleUIModel.Heading(
                text = "??????????????????",
            )
        ) +  List(3) {
            PlanScheduleUIModel.Section(
                number = it + 8,
                title = "????????????????????????????????????",
                description = "???????????????????????????????????????????????????????????????????????????\n" +
                    "??????????????????????????????????????????\n" +
                    "????????????????????????????????????????????????????????????????????????\n" +
                    "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
                startTime = LocalTime.of(10, 0),
                endTime = LocalTime.of(12, 0),
            )
        },
        createdAt = Instant.now(),
        places = listOf("????????? ????????????"),
        categories = listOf("??????", "????????????"),
        seasons = listOf("1~3???"),
        timeSpans = listOf("?????????"),
        cost = 10000,
    )
    DawnTheme {
        Scaffold(
            backgroundColor = White,
        ) {
            PlanDetailTemplate(
                uiModel = uiModel,
                onClickShare = {},
                onClickBookmark = {},
            )
        }
    }
}
