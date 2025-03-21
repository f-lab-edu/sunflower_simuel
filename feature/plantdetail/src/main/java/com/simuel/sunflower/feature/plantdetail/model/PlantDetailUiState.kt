package com.simuel.sunflower.feature.plantdetail.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.simuel.sunflower.core.domain.model.Plant

@Stable
sealed class PlantDetailUiState {
    @Immutable
    data object Loading : PlantDetailUiState()
    @Immutable
    data class Success(val plant: Plant) : PlantDetailUiState()
}
