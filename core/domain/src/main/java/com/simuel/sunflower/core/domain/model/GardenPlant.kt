package com.simuel.sunflower.core.domain.model

data class GardenPlant (
    val plantId: String,
    val plantName: String,
    val plantedDate: String,
    val lastWateringDate: String,
    val wateringIntervalInDays: Int,
    val imageUrl: String
)
