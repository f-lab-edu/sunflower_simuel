package com.simuel.sunflower.feature.gallery.component

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryTopBar(
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text("Photos by Unsplash")
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton (onClick = onBackClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
    )
}


@Preview
@Composable
private fun PreviewGalleryTopBar() {
    GalleryTopBar(onBackClick = { })
}
