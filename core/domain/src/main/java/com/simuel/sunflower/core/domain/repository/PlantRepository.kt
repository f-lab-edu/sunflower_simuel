package com.simuel.sunflower.core.domain.repository

import com.simuel.sunflower.core.domain.model.Plant

interface PlantRepository {
    fun getPlants(): List<Plant>
}
