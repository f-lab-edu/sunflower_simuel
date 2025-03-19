package com.simuel.sunflower.core.data.repository

import com.simuel.sunflower.core.data.mock.dummyPlants
import com.simuel.sunflower.core.domain.model.Plant
import com.simuel.sunflower.core.domain.repository.PlantDetailRepository
import javax.inject.Inject

internal class PlantDetailRepositoryImpl @Inject constructor(): PlantDetailRepository {
    override fun getPlantDetail(plantId: String): Plant {
        val plant = checkNotNull(dummyPlants.find { it.plantId == plantId }) {
            "Plant not found: $plantId"
        }
        return plant
    }
}
