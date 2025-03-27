package com.simuel.sunflower.feature.gallery.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simuel.sunflower.feature.gallery.model.GalleryUiPhoto

@Composable
fun GallerySuccessComponent(
    photos: List<GalleryUiPhoto>,
    onPhotoClick: (GalleryUiPhoto) -> Unit,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = photos,
            key = { photo -> photo.id }
        ) { photo ->
            ImageListItem(
                name = photo.name,
                imageUrl = photo.url,
                onClick = { onPhotoClick(photo) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GallerySuccessComponentPreview() {
    val previewPhotos = listOf(
        GalleryUiPhoto(
            id = "1",
            url = "https://images.unsplash.com/photo-1",
            name = "Sunflower",
            userName = "User1",
            description = "sunflower"
        ),
        GalleryUiPhoto(
            id = "2",
            url = "https://images.unsplash.com/photo-2",
            name = "Rose",
            userName = "User2",
            description = "rose"
        ),
        GalleryUiPhoto(
            id = "3",
            url = "https://images.unsplash.com/photo-3",
            name = "Tulip",
            userName = "User3",
            description = "tulip"
        ),
        GalleryUiPhoto(
            id = "4",
            url = "https://images.unsplash.com/photo-4",
            name = "Lily",
            userName = "User4",
            description = "lily"
        )
    )
    
    GallerySuccessComponent(
        photos = previewPhotos,
        onPhotoClick = {},
        modifier = Modifier
    )
}
