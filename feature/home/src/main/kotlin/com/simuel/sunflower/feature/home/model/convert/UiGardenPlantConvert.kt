package com.simuel.sunflower.feature.home.model.convert

import com.simuel.sunflower.core.domain.model.GardenPlant
import com.simuel.sunflower.feature.home.model.UiGardenPlant
import java.time.format.DateTimeFormatter

fun GardenPlant.toUiModel(): UiGardenPlant {
    val uiDateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy")
    return UiGardenPlant(
        plantId = plantId,
        plantName = plantName,
        plantedDateText = plantedDate.format(uiDateFormatter),
        lastWateringDateText = lastWateringDate.format(uiDateFormatter),
        wateringIntervalInDays = wateringIntervalInDays,
        imageUrl = imageUrl
    )
}
