package com.dawn.android.auth.ui.register.email.emailpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.MainTextButton
import com.dawn.android.common.ui.TopBar
import com.dawn.android.place.domain.model.Area
import com.dawn.android.place.domain.model.City
import com.dawn.android.place.domain.model.Prefecture
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray200
import com.dawn.android.ui.theme.Gray500
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.Typography

@Composable
fun EmailRegistrationCityTemplate(
    area: Area,
    prefecture: Prefecture,
    cities: List<City>,
    onClickBack: () -> Unit,
    onClickNext: (City) -> Unit,
) {
    val (city, setCity) = remember {
        mutableStateOf<City?>(null)
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
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = "${area.name} > ${prefecture.name} >",
                style = Typography.h5,
                color = Gray900,
                modifier = Modifier
                    .padding(
                        vertical = 24.dp,
                        horizontal = 36.dp
                    ),
            )
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 36.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = Gray200,
                        shape = Shapes.medium,
                    ),
            ) {
                items(cities) { item ->
                    val selected = city == item
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .selectable(
                                selected = selected,
                                onClick = {
                                    setCity(item)
                                }
                            )
                            .background(
                                color = if (selected) {
                                    Gray500
                                } else {
                                    Gray200
                                },
                            ),
                    ) {
                        Text(
                            text = item.name,
                            style = Typography.body2,
                            color = Gray900,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            MainTextButton(
                text = "次へ",
                onClick = {
                    city?.let {
                        onClickNext(it)
                    }
                },
                enabled = city != null,
                modifier = Modifier
                    .padding(
                        horizontal = 64.dp,
                    )
                    .fillMaxWidth()
                    .height(48.dp),
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun EmailRegistrationCityPreview() {
    DawnTheme {
        val area = Area(0, "東北")
        val prefecture = Prefecture(0, "福島")
        val cities = listOf(
            City(0, "福島市"),
            City(1, "郡山市"),
            City(2, "会津若松市"),
            City(3, "いわき市"),
        )
        EmailRegistrationCityTemplate(
            area = area,
            prefecture = prefecture,
            cities = cities,
            onClickBack = { /*TODO*/ },
            onClickNext = {}
        )
    }
}
