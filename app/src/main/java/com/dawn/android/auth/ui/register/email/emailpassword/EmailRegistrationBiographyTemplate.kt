package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.LimitedMultiLineGrayTextField
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.TopBar
import com.dawn.android.ui.theme.DawnTheme

@Composable
fun EmailRegistrationBiographyTemplate(
    onClickBack: () -> Unit,
    onClickNext: (String) -> Unit,
) {
    val (biography, setBiography) = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopBar(
                title = "自己紹介文の入力",
                navigationIcon = {
                    BackNavigationButton {
                        onClickBack()
                    }
                },
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            LimitedMultiLineGrayTextField(
                value = biography,
                onValueChange = setBiography,
                maxCount = 120,
                onLimitExceeded = { /*TODO*/ },
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                    )
                    .fillMaxWidth()
                    .height(246.dp),
            )
            Spacer(modifier = Modifier.height(64.dp))
            MainTextButton(
                text = "次へ",
                onClick = {
                    onClickNext(biography)
                },
                enabled = biography.isNotBlank() && biography.length <= 120,
                modifier = Modifier
                    .padding(
                        horizontal = 64.dp,
                    )
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
    }
}

@Preview
@Composable
fun EmailRegistrationBiographyPreview() {
    DawnTheme {
        EmailRegistrationBiographyTemplate(onClickBack = { /*TODO*/ }) {

        }
    }
}
