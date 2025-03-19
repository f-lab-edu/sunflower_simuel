package com.simuel.sunflower.feature.plantdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simuel.sunflower.core.domain.repository.PlantDetailRepository
import com.simuel.sunflower.feature.plantdetail.model.PlantDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    private val repository: PlantDetailRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<PlantDetailUiState>(PlantDetailUiState.Loading)
    val uiState: StateFlow<PlantDetailUiState> = _uiState.asStateFlow()

    fun loadPlantDetail(plantId: String) {
        _uiState.value = PlantDetailUiState.Loading

        viewModelScope.launch {
            val plant = repository.getPlantDetail(plantId)
            _uiState.value = PlantDetailUiState.Success(plant)
        }
    }
}
