package com.simuel.sunflower.core.data.model

internal data class GardenPlantDto(
    val plantId: String,
    val plantName: String,
    val plantedDate: String,
    val lastWateringDate: String,
    val wateringIntervalInDays: Int,
    val imageUrl: String
)
