package com.simuel.sunflower.core.data.repository

import com.simuel.sunflower.core.data.mock.dummyGardenPlant
import com.simuel.sunflower.core.domain.model.GardenPlant
import com.simuel.sunflower.core.domain.repository.GardenRepository
import javax.inject.Inject

internal class GardenRepositoryImpl @Inject constructor() : GardenRepository {
    override fun getGardenPlants(): List<GardenPlant> {
        return dummyGardenPlant
    }

}
