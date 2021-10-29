package com.dawn.android.auth.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.SubMainTextButton
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White

@Composable
fun RegisterDoneTemplate(
    onClickDone: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "アカウントが\n" +
                "登録されました！",
            style = Typography.h4,
            color = Gray900,
        )
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "追加で職業を設定すると\n" +
                "クリエーターに登録され\n" +
                "なるとプランを作成できます",
            style = Typography.body1,
            color = Gray900,
        )
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 64.dp,
                )
                .fillMaxWidth(),
        ) {
            MainTextButton(
                text = "登録を終わる",
                onClick = onClickDone,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
            Spacer(modifier = Modifier.height(40.dp))
            SubMainTextButton(
                text = "クリエイターになる",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
        Spacer(modifier = Modifier.height(76.dp))
    }
}

@Preview
@Composable
fun RegisterDonePreview() {
    DawnTheme {
        Surface(
            color = White
        ) {
            RegisterDoneTemplate {

            }
        }
    }
}
