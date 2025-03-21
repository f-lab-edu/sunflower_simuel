package com.simuel.sunflower.core.domain.model

import java.time.LocalDate

data class GardenPlant (
    val plantId: String,
    val plantName: String,
    val plantedDate: LocalDate,
    val lastWateringDate: LocalDate,
    val wateringIntervalInDays: Int,
    val imageUrl: String
)
