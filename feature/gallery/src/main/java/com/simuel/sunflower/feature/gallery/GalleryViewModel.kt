package com.simuel.sunflower.feature.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simuel.sunflower.core.domain.repository.GalleryRepository
import com.simuel.sunflower.feature.gallery.model.GalleryUiState
import com.simuel.sunflower.feature.gallery.model.UiGalleryPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: GalleryRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<GalleryUiState>(GalleryUiState.Loading)
    val uiState: StateFlow<GalleryUiState> = _uiState.asStateFlow()

    fun requestGalleryImages(
        category: String,
    ) {
        viewModelScope.launch {
            flow {
                val photos = repository.getCategoryPhotos(
                    category = category, page = 1, pageSize = 10
                )
                emit(photos)
            }.map { domainPhotos ->
                GalleryUiState.Success(
                    domainPhotos.map { photo ->
                        UiGalleryPhoto(
                            id = photo.id,
                            url = photo.url,
                            name = photo.name,
                            userName = photo.userName,
                            description = photo.description
                        )
                    })
            }.onStart {
                _uiState.value = GalleryUiState.Loading
            }.catch { throwable ->
                _uiState.value = GalleryUiState.Error(throwable.message ?: "알수 없는 에러")
            }.collect { state ->
                _uiState.value = state
            }
        }
    }
}
