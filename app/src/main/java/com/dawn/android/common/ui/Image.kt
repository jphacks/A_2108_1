package com.dawn.android.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CreatorProfileIcon(
    imageUrl: String,
) {
    Image(
        painter = rememberImagePainter(data = imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape),
    )
}
