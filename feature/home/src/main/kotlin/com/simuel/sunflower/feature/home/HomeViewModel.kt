package com.simuel.sunflower.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simuel.sunflower.core.domain.model.Plant
import com.simuel.sunflower.core.domain.repository.GardenRepository
import com.simuel.sunflower.core.domain.repository.PlantRepository
import com.simuel.sunflower.feature.home.model.UiGardenPlant
import com.simuel.sunflower.feature.home.model.convert.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gardenRepository: GardenRepository, private val plantRepository: PlantRepository
) : ViewModel() {
    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex: StateFlow<Int> = _selectedTabIndex

    private val _gardenPlants: MutableStateFlow<List<UiGardenPlant>> = MutableStateFlow(emptyList())
    val gardenPlants: StateFlow<List<UiGardenPlant>> = _gardenPlants

    private val _plants: MutableStateFlow<List<Plant>> = MutableStateFlow(emptyList())
    val plants: StateFlow<List<Plant>> = _plants

    fun updateSelectedTabIndex(index: Int) {
        _selectedTabIndex.value = index
    }

    fun loadPlants() {
        viewModelScope.launch {
            _plants.value = plantRepository.loadPlants()
        }
    }

    fun loadGardenPlants() {
        viewModelScope.launch {
            _gardenPlants.value = gardenRepository.loadGardenPlants().map {
                it.toUiModel()
            }
        }
    }
}
