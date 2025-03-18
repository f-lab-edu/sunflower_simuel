package com.simuel.sunflower.core.domain.repository

import com.simuel.sunflower.core.domain.model.Plant

interface PlantDetailRepository {
    fun getPlantDetail(plantId: String): Plant
}
