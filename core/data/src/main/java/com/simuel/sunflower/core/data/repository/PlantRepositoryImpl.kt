package com.simuel.sunflower.core.data.repository

import com.simuel.sunflower.core.data.mock.dummyPlants
import com.simuel.sunflower.core.domain.model.Plant
import com.simuel.sunflower.core.domain.repository.PlantRepository
import javax.inject.Inject

internal class PlantRepositoryImpl @Inject constructor(): PlantRepository {
    override fun getPlants(): List<Plant> {
        return dummyPlants
    }
}
