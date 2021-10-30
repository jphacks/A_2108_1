package com.dawn.android.user.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dawn.android.R
import com.dawn.android.place.domain.model.Place
import com.dawn.android.plan.domain.model.PlaceId
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray200
import com.dawn.android.ui.theme.Gray500
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.MainColor
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.SubMainColor
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White
import com.dawn.android.user.domain.model.Contact
import com.dawn.android.user.domain.model.Creator
import com.dawn.android.user.domain.model.MaskedUser
import com.dawn.android.user.domain.model.Me
import com.dawn.android.user.domain.model.OtherUser
import com.dawn.android.user.domain.model.Sex
import com.dawn.android.user.domain.model.User
import com.dawn.android.user.domain.model.UserId
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.time.LocalDate

@Composable
fun UserTemplate(
    user: MaskedUser,
) {
    val systemUiController = rememberSystemUiController()
    DisposableEffect(Unit) {
        systemUiController.setStatusBarColor(MainColor)
        return@DisposableEffect onDispose {
            systemUiController.setSystemBarsColor(White)
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        UserHeader(user)
        UserContent(user = user, onClickLink = {})
    }
}

@Composable
fun UserHeader(user: MaskedUser) {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .background(
                    color = MainColor,
                    shape = RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp,
                    )
                )
        )
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                )
                .fillMaxWidth(),
        ) {
            if (user is Creator) {
                Text(
                    text = "クリエーター",
                    style = Typography.body2,
                    color = Gray900,
                    modifier = Modifier
                        .background(
                            color = SubMainColor,
                            shape = Shapes.medium,
                        )
                        .padding(
                            horizontal = 8.dp,
                        ),
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(80.dp),
            ) {
                Text(
                    text = user.displayName,
                    style = Typography.h5,
                    color = Gray900,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = user.imageUrl,
                        builder = {
                            placeholder(R.drawable.placeholder)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(
                            shape = Shapes.medium,
                        ),
                )
                Spacer(modifier = Modifier.width(24.dp))
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 8.dp,
                            shape = Shapes.medium,
                        )
                        .weight(1f)
                        .height(80.dp)
                        .background(
                            color = White,
                            shape = Shapes.medium,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    when (user) {
                        is Me.Normal -> {
                            Text(
                                text = "クリエーターに登録して\n" +
                                    "プランを作成する",
                                style = Typography.body2,
                                color = Gray900,
                                textAlign = TextAlign.Center,
                            )
                        }
                        is Me.TravelCreator -> {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = "自分のプラン",
                                    style = Typography.body2,
                                    color = Gray900,
                                )
                                Text(
                                    text = "0",
                                    style = Typography.h5,
                                    color = Gray900,
                                )
                            }
                        }
                        is OtherUser.TravelCreator -> {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = "プラン",
                                    style = Typography.body2,
                                    color = Gray900,
                                )
                                Text(
                                    text = "0",
                                    style = Typography.h5,
                                    color = Gray900,
                                )
                            }
                        }
                        is OtherUser.Normal -> {
                            // unreachable code
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserContent(
    user: MaskedUser,
    onClickLink: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "@${user.userName}",
            style = Typography.body2,
            color = Gray700,
        )
        if (user is User) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = null,
                    tint = Gray900,
                )
                Text(
                    text = user.place.name,
                    style = Typography.body2,
                    color = Gray900,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(224.dp)
                .background(
                    color = Gray200,
                    shape = Shapes.medium,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = user.contacts.biography,
                style = Typography.subtitle2,
                color = Gray900,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp,
                    )
                    .fillMaxWidth()
                    .weight(1f),
            )
//            val contacts = listOf(
//                user.contacts.hpLink to Icons.Outlined.Link,
//                user.contacts.instagramLink to R.drawable.ic_instagram,
//                user.contacts.twitterLink to R.drawable.ic_twitter,
//                user.contacts.tiktokLink to R.drawable.ic_tiktok,
//                user.contacts.facebookLink to R.drawable.ic_facebook,
//            ).mapNotNull { (link, resource) ->
//                link?.let {
//                    it to resource
//                }
//            }
//            if (contacts.isNotEmpty()) {
//                Row(
//                    modifier = Modifier.height(40.dp),
//                ) {
//                    contacts.forEachIndexed { i, (link, res) ->
//                        if (res is ImageVector) {
//                            Button(onClick = {
//                                onClickLink(link)
//                            }) {
//                                Icon(
//                                    imageVector = res,
//                                    contentDescription = null,
//                                    tint = Gray900,
//                                )
//                            }
//                        } else if (res is Int) {
//                            Button(
//                                onClick = {
//                                    onClickLink(link)
//                                },
//                            ) {
//                                Icon(
//                                    painter = painterResource(id = res),
//                                    contentDescription = null,
//                                )
//                            }
//                        }
//                        if (i < contacts.lastIndex) {
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxHeight()
//                                    .width(1.dp)
//                                    .background(
//                                        color = Gray500,
//                                    )
//                            )
//                        }
//                    }
//                }
//            }
        }
    }
}

@Preview
@Composable
fun UserPreview() {
    DawnTheme {
        Surface(
            color = White
        ) {
            val user = Me.Normal(
                userId = UserId(0),
                userName = "monolog",
                imageUrl = "",
                displayName = "星野ユウスイ",
                contacts = Contact(
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
                ),
                email = "",
                dateOfBirth = LocalDate.of(2000, 1, 1),
                sex = Sex.Male,
                place = Place(
                    PlaceId(0),
                    0,
                    0,
                    0,
                    "福島県会津若松市",
                )
            )
            UserTemplate(user)
        }
    }
}
