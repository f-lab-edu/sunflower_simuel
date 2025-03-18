package com.simuel.sunflower.core.domain.repository
import com.simuel.sunflower.core.domain.model.GardenPlant

interface GardenRepository {
    fun getGardenPlants(): List<GardenPlant>
}
