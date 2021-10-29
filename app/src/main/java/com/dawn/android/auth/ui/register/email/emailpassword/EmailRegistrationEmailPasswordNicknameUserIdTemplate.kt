package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.dawn.android.common.ui.LimitedSingleLineGrayTextField
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.NoLimitSingleLineGrayTextField
import com.dawn.android.common.ui.PasswordSingleLineGrayTextField
import com.dawn.android.common.ui.TopBar
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Typography
import com.dawn.android.user.domain.model.Area
import com.dawn.android.user.domain.model.City
import com.dawn.android.user.domain.model.Contact
import com.dawn.android.user.domain.model.Prefecture

@Composable
fun EmailRegistrationEmailPasswordNicknameUserIdTemplate(
    onClickBack: () -> Unit,
    onClickNext: (email: String, password: String, nickname: String, userId: String) -> Unit,
) {
    val (email, setEmail) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }
    val (nickname, setNickname) = remember {
        mutableStateOf("")
    }
    val (userId, setUserId) = remember {
        mutableStateOf("")
    }
    val (prefecture, setPrefecture) = remember {
        mutableStateOf<Prefecture?>(null)
    }
    val (city, setCity) = remember {
        mutableStateOf<City?>(null)
    }
    val (contact, setContact) = remember {
        mutableStateOf(Contact.empty())
    }
    Scaffold(
        topBar = {
            TopBar(
                title = "アカウント情報の入力",
                navigationIcon = {
                    BackNavigationButton {
                        onClickBack()
                    }
                },
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
            item {
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
                    Spacer(modifier = Modifier.height(24.dp))
                    TextFieldLabel(text = "ニックネーム(3文字以上)")
                    LimitedSingleLineGrayTextField(
                        value = nickname,
                        onValueChange = setNickname,
                        maxCount = 20,
                        onLimitExceeded = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextFieldLabel(text = "ユーザID(3文字以上)")
                    LimitedSingleLineGrayTextField(
                        value = userId,
                        onValueChange = setUserId,
                        maxCount = 16,
                        onLimitExceeded = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(64.dp))
                }
            }
            item {
                val enabled = true // TODO
                MainTextButton(
                    text = "次へ",
                    onClick = {
                        onClickNext(email, password, nickname, userId)
                    },
                    enabled = enabled,
                    modifier = Modifier
                        .padding(horizontal = 64.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                )
            }
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
