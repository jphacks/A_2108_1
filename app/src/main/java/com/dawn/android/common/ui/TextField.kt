package com.dawn.android.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dawn.android.ui.theme.AccentRed
import com.dawn.android.ui.theme.BackgroundColor
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray200
import com.dawn.android.ui.theme.Gray500
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.Shapes
import com.dawn.android.ui.theme.Typography
import com.dawn.android.ui.theme.White

@Composable
fun NoLimitSingleLineGrayTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    BaseGrayTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = placeholder,
        textStyle = Typography.h6,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        trailingIcon = {}
    )
}

@Composable
fun LimitedSingleLineGrayTextField(
    value: String,
    onValueChange: (String) -> Unit,
    maxCount: Int,
    onLimitExceeded: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val limitExceeded = value.length > maxCount
    if (limitExceeded) {
        onLimitExceeded()
    }
    BaseGrayTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = placeholder,
        textStyle = Typography.h6,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        trailingIcon = {
            Text(
                text = "${value.length}/$maxCount",
                style = Typography.body2,
                color = if (limitExceeded) AccentRed else Gray500,
            )
        }
    )
}

@Composable
fun PasswordSingleLineGrayTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    passwordVisible: Boolean = false,
    onChangePasswordVisible: (Boolean) -> Unit,
) {
    BaseGrayTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = Typography.h6,
        placeholder = null,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
        ),
        singleLine = true,
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            val image = if (passwordVisible) {
                Icons.Outlined.Visibility
            } else {
                Icons.Outlined.VisibilityOff
            }
            IconButton(onClick = {
                onChangePasswordVisible(!passwordVisible)
            }) {
                Icon(
                    imageVector = image,
                    contentDescription = null,
                    tint = Gray900,
                )
            }
        }
    )
}

@Composable
private fun BaseGrayTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    textStyle: TextStyle,
    placeholder: String?,
    keyboardOptions: KeyboardOptions,
    singleLine: Boolean,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle,
        placeholder = placeholder?.let { {
            Placeholder(text = it)
        } },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Gray900,
            backgroundColor = Gray200,
            focusedIndicatorColor = BackgroundColor,
            unfocusedIndicatorColor = BackgroundColor,
            disabledIndicatorColor = BackgroundColor,
            errorIndicatorColor = BackgroundColor,
            placeholderColor = Gray500,
        ),
        shape = Shapes.medium,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
    )
}

@Composable
private fun Placeholder(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun TextFieldPreview() {
    DawnTheme {
        Column(
            modifier = Modifier
                .background(White)
                .padding(16.dp),
        ) {
            NoLimitSingleLineGrayTextField(value = "hogehoge", onValueChange = {}, placeholder = "")
            NoLimitSingleLineGrayTextField(value = "", onValueChange = {}, placeholder = "入力")
            LimitedSingleLineGrayTextField(
                value = "hogehoge",
                onValueChange = {},
                maxCount = 16,
                onLimitExceeded = { /*TODO*/ },
            )
            LimitedSingleLineGrayTextField(
                value = "hogehogehogehogehoge",
                onValueChange = {},
                maxCount = 16,
                onLimitExceeded = { /*TODO*/ },
            )
            PasswordSingleLineGrayTextField(
                value = "hogehoge",
                onValueChange = {},
                passwordVisible = false,
                onChangePasswordVisible = {}
            )
            PasswordSingleLineGrayTextField(
                value = "hogehoge",
                onValueChange = {},
                passwordVisible = true,
                onChangePasswordVisible = {}
            )
        }
    }
}
