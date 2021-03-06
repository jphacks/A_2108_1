package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.dawn.android.common.ui.SelectableSection
import com.dawn.android.common.ui.TopBar
import com.dawn.android.place.domain.model.Area
import com.dawn.android.ui.theme.DawnTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EmailRegistrationAreaTemplate(
    areas: List<Area>,
    onClickBack: () -> Unit,
    onClickArea: (Area) -> Unit,
) {
    val (area, setArea) = remember {
        mutableStateOf<Area?>(null)
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
            Spacer(modifier = Modifier.height(80.dp))
            SelectableSection(
                items = areas,
                selectedItem = area,
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                    )
                    .fillMaxWidth(),
                getText = { it.name },
                onSelect = {
                    setArea(it)
                    onClickArea(it)
                },
            )
        }
    }
}

@Preview
@Composable
fun EmailRegistrationAreaPreview() {
    DawnTheme {
        val areas = listOf(
            Area(0, "北海道"),
            Area(1, "東北"),
            Area(2, "関東"),
            Area(3, "中部"),
            Area(4, "近畿"),
            Area(5, "中国"),
            Area(6, "四国"),
            Area(7, "九州")
        )
        EmailRegistrationAreaTemplate(areas = areas, onClickBack = { /*TODO*/ }, onClickArea = {})
    }
}
