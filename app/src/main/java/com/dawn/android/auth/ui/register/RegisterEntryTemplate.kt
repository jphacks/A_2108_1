package com.dawn.android.auth.ui.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.MainOutlinedTextButton
import com.dawn.android.ui.theme.DawnTheme

@Composable
fun RegisterEntryTemplate(
    onClickEmailRegistration: () -> Unit,
) {
    Scaffold {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 64.dp),
        ) {
            MainOutlinedTextButton(
                text = "メールアドレスで登録",
                onClick = onClickEmailRegistration,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
    }
}

@Preview
@Composable
fun RegisterEntryPreview() {
    DawnTheme {
        RegisterEntryTemplate {

        }
    }
}
