package com.dawn.android.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.MainColor
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.SubMainColor
import com.dawn.android.ui.theme.White

@Composable
fun MainTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MainColor,
            contentColor = Gray900,
            disabledBackgroundColor = SubMainColor,
            disabledContentColor = Gray700,
        ),
        shape = Shapes.medium,
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun SubMainTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = SubMainColor,
            contentColor = Gray900,
            disabledBackgroundColor = SubMainColor,
            disabledContentColor = Gray700,
        ),
        shape = Shapes.medium,
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun GrayTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Gray700,
            contentColor = Gray900,
            disabledBackgroundColor = SubMainColor,
            disabledContentColor = Gray700,
        ),
        shape = Shapes.medium,
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun BackNavigationButton(
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .background(
                color = MainColor,
                shape = Shapes.medium,
            )
            .padding(start = 8.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBackIos,
            contentDescription = null,
            tint = Gray900,
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
    DawnTheme {
        Column(
            modifier = Modifier
                .background(White)
                .padding(16.dp),
        ) {
            MainTextButton(text = "ボタン", onClick = { /*TODO*/ })
            SubMainTextButton(text = "ボタン", onClick = { /*TODO*/ })
            GrayTextButton(text = "ボタン", onClick = { /*TODO*/ })
            BackNavigationButton {}
        }
    }
}
