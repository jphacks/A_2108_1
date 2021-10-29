package com.dawn.android.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dawn.android.ui.theme.AccentBlue
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray200
import com.dawn.android.ui.theme.Gray500
import com.dawn.android.ui.theme.Gray700
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.MainColor
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.SubMainColor
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White

@Composable
fun MainTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MainColor,
            contentColor = Gray900,
            disabledBackgroundColor = Gray500,
            disabledContentColor = Gray900,
        ),
        shape = Shapes.medium,
        enabled = enabled,
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MainOutlinedTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        elevation = ButtonDefaults.elevation(14.dp),
        shape = Shapes.medium,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = White,
            contentColor = Gray900,
        ),
        border = BorderStroke(
            width = 2.dp,
            color = MainColor,
        ),
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 4.dp),
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

@Composable
fun ShareButton(
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(44.dp)
            .background(
                color = Gray200,
                shape = Shapes.small,
            ),
    ) {
        Icon(
            imageVector = Icons.Outlined.Share,
            contentDescription = null,
            tint = Gray900,
        )
    }
}

@Composable
fun BookmarkButton(
    bookmarkCount: Int,
    bookmarked: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (bookmarked) AccentBlue else Gray200,
            contentColor = if (bookmarked) White else Gray900,
        ),
        shape = Shapes.small,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(
            width = 94.dp,
            height = 44.dp,
        ),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = if (bookmarked) {
                    Icons.Outlined.Bookmark
                } else {
                    Icons.Outlined.BookmarkBorder
                },
                contentDescription = null,
                tint = if (bookmarked) White else Gray500,
            )
            Text(
                text = bookmarkCount.toString(),
                style = Typography.body2,
            )
        }
    }
}

@Composable
fun SelectableButton(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .selectable(
                selected = selected,
                onClick = onClick,
            )
            .background(
                color = if (selected) {
                    MainColor
                } else {
                    Gray200
                },
                shape = Shapes.medium,
            ),
    ) {
        Text(
            text = text,
            style = Typography.h6,
            color = Gray900,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> SelectableSection(
    items: List<T>,
    selectedItem: T?,
    modifier: Modifier = Modifier,
    getText: (T) -> String,
    onSelect: (T) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 92.dp),
        modifier = modifier,
    ) {
        items(items) { item ->
            Box(
                modifier = Modifier
                    .padding(12.dp),
                contentAlignment = Alignment.Center,
            ) {
                SelectableButton(
                    text = getText(item),
                    selected = item == selectedItem,
                    modifier = Modifier.size(
                        width = 80.dp,
                        height = 56.dp,
                    )
                ) {
                    onSelect(item)
                }
            }
        }
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
            MainOutlinedTextButton(text = "ボタン", onClick = { /*TODO*/ })
            SubMainTextButton(text = "ボタン", onClick = { /*TODO*/ })
            GrayTextButton(text = "ボタン", onClick = { /*TODO*/ })
            BackNavigationButton {}
            ShareButton {}
            BookmarkButton(bookmarkCount = 0, bookmarked = true) {}
            BookmarkButton(bookmarkCount = 0, bookmarked = false) {}
        }
    }
}
