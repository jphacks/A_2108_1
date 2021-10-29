package com.dawn.android.auth.ui.register.email

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.NoLimitSingleLineGrayTextField
import com.dawn.android.common.ui.PasswordSingleLineGrayTextField
import com.dawn.android.common.ui.TopBar
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Typography

@Composable
fun EmailPasswordTemplate(
    onClickBack: () -> Unit,
    onClickNext: (email: String, password: String) -> Unit,
) {
    val (email, setEmail) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopBar(
                title = "連絡先の入力",
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
            Spacer(modifier = Modifier.height(56.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 48.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "メールアドレス",
                    style = Typography.body2,
                    color = Gray700,
                )
                NoLimitSingleLineGrayTextField(
                    value = email,
                    onValueChange = setEmail,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "パスワード(6文字以上)",
                    style = Typography.body2,
                    color = Gray700,
                )
                val (passwordVisible, setPasswordVisible) = remember {
                    mutableStateOf(false)
                }
                PasswordSingleLineGrayTextField(
                    value = password,
                    onValueChange = setPassword,
                    passwordVisible = passwordVisible,
                    onChangePasswordVisible = setPasswordVisible,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            val enabled = email.isNotBlank() && password.length >= 6
            MainTextButton(
                text = "次へ",
                onClick = {
                    onClickNext(email, password)
                },
                enabled = enabled,
                modifier = Modifier
                    .padding(horizontal = 64.dp)
                    .fillMaxWidth()
                    .height(48.dp),
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Preview
@Composable
fun EmailPasswordPreview() {
    DawnTheme {
        EmailPasswordTemplate(onClickBack = { /*TODO*/ }, onClickNext = { email, password ->

        })
    }
}
