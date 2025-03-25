package com.simuel.sunflower.feature.gallery.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable


@Stable
sealed interface GalleryUiState {

    @Immutable
    data object Loading : GalleryUiState

    @Immutable
    data class Success(val photos: List<UiGalleryPhoto>) : GalleryUiState

    @Immutable
    data class Error(val errorMessage: String) : GalleryUiState
}

@Immutable
data class UiGalleryPhoto(
    val id: String,
    val url: String,
    val name: String,
    val userName: String,
    val description: String
) 
