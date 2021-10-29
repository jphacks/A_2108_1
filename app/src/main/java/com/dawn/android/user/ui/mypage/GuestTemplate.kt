package com.dawn.android.user.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.TopBar
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray500
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White

@Composable
fun GuestTemplate(
    onClickRegister: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(title = "ゲスト")
        },
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp,
                )
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 14.dp,
                        shape = Shapes.large,
                    )
                    .fillMaxWidth()
                    .background(
                        color = White,
                        shape = Shapes.large,
                    )
                    .border(
                        width = 1.dp,
                        color = Gray500,
                        shape = Shapes.large,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "アカウントを作成すると\n" +
                        "・レビューの追加\n" +
                        "・フォロー機能\n" +
                        "・自己紹介文\n" +
                        "などを追加できます。\n" +
                        "アカウントを登録しますか？",
                    textAlign = TextAlign.Center,
                    style = Typography.body1,
                    color = Gray900,
                )
                Spacer(modifier = Modifier.height(16.dp))
                MainTextButton(
                    text = "登録する",
                    onClick = onClickRegister,
                    modifier = Modifier
                        .padding(horizontal = 48.dp)
                        .height(48.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview
@Composable
fun GuestPreview() {
    DawnTheme {
        GuestTemplate {

        }
    }
}
