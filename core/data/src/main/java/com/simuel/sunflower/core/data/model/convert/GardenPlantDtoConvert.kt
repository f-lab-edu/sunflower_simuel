package com.simuel.sunflower.core.data.model.convert

import com.simuel.sunflower.core.data.model.GardenPlantDto
import com.simuel.sunflower.core.domain.model.GardenPlant
import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal fun GardenPlantDto.toGardenPlant(): GardenPlant {
    val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
    return GardenPlant(
        plantId = plantId,
        plantName = plantName,
        plantedDate = LocalDate.parse(plantedDate, formatter),
        lastWateringDate = LocalDate.parse(lastWateringDate, formatter),
        wateringIntervalInDays = wateringIntervalInDays,
        imageUrl = imageUrl
    )
}
