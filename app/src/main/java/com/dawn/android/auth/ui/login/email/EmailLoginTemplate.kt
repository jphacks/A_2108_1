package com.dawn.android.auth.ui.login.email

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
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.NoLimitSingleLineGrayTextField
import com.dawn.android.common.ui.PasswordSingleLineGrayTextField
import com.dawn.android.common.ui.TopBar
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Typography

@Composable
fun EmailLoginTemplate(
    onBackPressed: () -> Unit,
    onClickLogin: (email: String, password: String) -> Unit,
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
                title = "ログイン",
                navigationIcon = {
                    BackNavigationButton {
                        onBackPressed()
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
                TextFieldLabel(text = "メールアドレス")
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
                TextFieldLabel(text = "パスワード(6文字以上)")
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
            MainTextButton(
                text = "ログイン",
                onClick = {
                    onClickLogin(email, password)
                },
                enabled = email.isNotBlank() && password.isNotEmpty(),
                modifier = Modifier
                    .padding(horizontal = 64.dp)
                    .fillMaxWidth()
                    .height(48.dp),
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
private fun TextFieldLabel(text: String) {
    Text(
        text = text,
        style = Typography.body2,
        color = Gray700,
    )
}
