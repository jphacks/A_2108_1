package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.SelectableSection
import com.dawn.android.common.ui.TopBar
import com.dawn.android.place.domain.model.Area
import com.dawn.android.place.domain.model.Prefecture
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Typography

@Composable
fun EmailRegistrationPrefectureTemplate(
    area: Area,
    prefectures: List<Prefecture>,
    onClickBack: () -> Unit,
    onClickPrefecture: (Prefecture) -> Unit,
) {
    val (prefecture, setPrefecture) = remember {
        mutableStateOf<Prefecture?>(null)
    }
    Scaffold(
        topBar = {
            TopBar(
                title = "居住地の選択",
                navigationIcon = {
                    BackNavigationButton {
                        onClickBack()
                    }
                },
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "${area.name} >",
                style = Typography.h5,
                color = Gray900,
                modifier = Modifier
                    .padding(
                        vertical = 24.dp,
                        horizontal = 36.dp
                    )
            )
            SelectableSection(
                items = prefectures,
                selectedItem = prefecture,
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                    )
                    .fillMaxWidth(),
                getText = { it.name },
                onSelect = {
                    setPrefecture(it)
                    onClickPrefecture(it)
                },
            )
        }
    }
}

@Preview
@Composable
fun EmailRegistrationPrefecturePreview() {
    DawnTheme {
        val prefectures = listOf(
            Prefecture(0, "青森"),
            Prefecture(1, "秋田"),
            Prefecture(2, "岩手"),
            Prefecture(3, "山形"),
            Prefecture(4, "宮城"),
            Prefecture(5, "福島"),
        )
        EmailRegistrationPrefectureTemplate(
            area = Area(0, "東北"),
            prefectures = prefectures,
            onClickBack = { /*TODO*/ },
            onClickPrefecture = {},
        )
    }
}
