package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.NoLimitSingleLineWhiteTextField
import com.dawn.android.common.ui.TopBar
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Typography
import com.dawn.android.user.domain.model.Contact

@Composable
fun EmailRegistrationContactTemplate(
    onClickBack: () -> Unit,
    onClickNext: (Contact) -> Unit,
) {
    val (hp, setHp) = remember {
        mutableStateOf("")
    }
    val (instagram, setInstagram) = remember {
        mutableStateOf("")
    }
    val (twitter, setTwitter) = remember {
        mutableStateOf("")
    }
    val (facebook, setFacebook) = remember {
        mutableStateOf("")
    }
    val (tikTok, setTikTok) = remember {
        mutableStateOf("")
    }
    val contact = Contact(
        hpLink = hp.takeIf { it.isNotBlank() },
        instagramLink = instagram.takeIf { it.isNotBlank() },
        twitterLink = twitter.takeIf { it.isNotBlank() },
        facebookLink = facebook.takeIf { it.isNotBlank() },
        tiktokLink = tikTok.takeIf { it.isNotBlank() },
        biography = ""
    )
    Scaffold(
        topBar = {
            TopBar(
                title = "SNSの入力",
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
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                    )
                    .fillMaxWidth(),
            ) {
                SNSRow(
                    label = "HP",
                    url = hp,
                    onValueChange = setHp,
                )
                Spacer(modifier = Modifier.height(16.dp))
                SNSRow(
                    label = "Instagram",
                    url = instagram,
                    onValueChange = setInstagram,
                )
                Spacer(modifier = Modifier.height(16.dp))
                SNSRow(
                    label = "Twitter",
                    url = twitter,
                    onValueChange = setTwitter,
                )
                Spacer(modifier = Modifier.height(16.dp))
                SNSRow(
                    label = "Facebook",
                    url = facebook,
                    onValueChange = setFacebook,
                )
                Spacer(modifier = Modifier.height(16.dp))
                SNSRow(
                    label = "TikTok",
                    url = tikTok,
                    onValueChange = setTikTok,
                )
            }
            Spacer(modifier = Modifier.height(104.dp))
            MainTextButton(
                text = "次へ",
                onClick = {
                    onClickNext(contact)
                },
                modifier = Modifier
                    .padding(horizontal = 64.dp)
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
    }
}

@Composable
private fun SNSRow(
    label: String,
    url: String,
    onValueChange: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = Typography.body1,
            color = Gray900,
            modifier = Modifier.width(80.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        NoLimitSingleLineWhiteTextField(
            value = url,
            onValueChange = onValueChange,
            placeholder = "URL",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun EmailRegistrationContactPreview() {
    DawnTheme {
        EmailRegistrationContactTemplate(onClickBack = { /*TODO*/ }) {

        }
    }
}
