package com.simuel.sunflower.feature.home.model

data class UiGardenPlant(
    val plantId: String,
    val plantName: String,
    val plantedDateText: String,
    val lastWateringDateText: String,
    val wateringIntervalInDays: Int,
    val imageUrl: String
)
