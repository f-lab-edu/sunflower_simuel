package com.simuel.sunflower.feature.gallery

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.simuel.sunflower.core.domain.model.Photo
import com.simuel.sunflower.feature.gallery.component.GalleryErrorComponent
import com.simuel.sunflower.feature.gallery.component.GalleryLoadingComponent
import com.simuel.sunflower.feature.gallery.component.GallerySuccessComponent
import com.simuel.sunflower.feature.gallery.component.GalleryTopBar
import com.simuel.sunflower.feature.gallery.model.GalleryUiState
import com.simuel.sunflower.feature.gallery.model.UiGalleryPhoto


@Composable
fun GalleryScreen(
    plantName: String,
    onPhotoClick: (Photo) -> Unit,
    onBackClick: () -> Unit,
) {
    val context = LocalContext.current
    val viewModel: GalleryViewModel = hiltViewModel()
    val galleryState by viewModel.uiState.collectAsState()

    LaunchedEffect(plantName) {
        viewModel.requestGalleryPhotos(plantName)
    }

    GalleryScreenContent(
        uiState = galleryState,
        onPhotoClick = { uiPhoto ->

            val intent = Intent(Intent.ACTION_VIEW, uiPhoto.url.toUri())
            context.startActivity(intent)
            val domainPhoto = Photo(
                id = uiPhoto.id,
                name = uiPhoto.name,
                url = uiPhoto.url,
                userName = uiPhoto.userName,
                description = uiPhoto.description
            )
            onPhotoClick(domainPhoto)
        },
        onBackClick = onBackClick
    )
}

@Composable
private fun GalleryScreenContent(
    uiState: GalleryUiState,
    onPhotoClick: (UiGalleryPhoto) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier,
        topBar = { GalleryTopBar(onBackClick = onBackClick) }
    ) { paddingValues ->
        val component = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            
        when (uiState) {
            is GalleryUiState.Loading -> {
                GalleryLoadingComponent(modifier = component)
            }
            is GalleryUiState.Success -> {
                GallerySuccessComponent(
                    photos = uiState.photos,
                    onPhotoClick = onPhotoClick,
                    modifier = component
                )
            }
            is GalleryUiState.Error -> {
                GalleryErrorComponent(
                    errorMessage = uiState.errorMessage,
                    modifier = component
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "갤러리 로딩중")
@Composable
private fun GalleryScreenUiStateLoadingPreview() {
    GalleryScreenContent(
        uiState = GalleryUiState.Loading,
        onPhotoClick = {},
        onBackClick = {}
    )
}

@Preview(showBackground = true, name = "갤러리 불러오기 성공")
@Composable
private fun GalleryScreenUiStateSuccessPreview() {
    val previewPhotos = listOf(
        UiGalleryPhoto(
            id = "1",
            url = "https://images.unsplash.com/photo-1",
            name = "Sunflower",
            userName = "User1",
            description = "Beautiful sunflower"
        ),
        UiGalleryPhoto(
            id = "2",
            url = "https://images.unsplash.com/photo-2",
            name = "Rose",
            userName = "User2",
            description = "Red rose"
        ),
        UiGalleryPhoto(
            id = "3",
            url = "https://images.unsplash.com/photo-3",
            name = "Tulip",
            userName = "User3",
            description = "Yellow tulip"
        ),
        UiGalleryPhoto(
            id = "4",
            url = "https://images.unsplash.com/photo-4",
            name = "Lily",
            userName = "User4",
            description = "White lily"
        )
    )
    
    GalleryScreenContent(
        uiState = GalleryUiState.Success(photos = previewPhotos),
        onPhotoClick = {},
        onBackClick = {}
    )
}

@Preview(showBackground = true, name = "갤러리 불러오기 실패")
@Composable
private fun GalleryScreenUiStateErrorPreview() {
    GalleryScreenContent(
        uiState = GalleryUiState.Error(errorMessage = "이미지 로드 실패"),
        onPhotoClick = {},
        onBackClick = {}
    )
}
