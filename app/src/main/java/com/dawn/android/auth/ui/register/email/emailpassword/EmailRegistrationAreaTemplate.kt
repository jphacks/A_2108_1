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
import androidx.compose.ui.unit.dp
import com.dawn.android.common.ui.BackNavigationButton
import com.dawn.android.common.ui.SelectableSection
import com.dawn.android.common.ui.TopBar
import com.dawn.android.place.domain.model.Area

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
                        horizontal = 36.dp,
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
