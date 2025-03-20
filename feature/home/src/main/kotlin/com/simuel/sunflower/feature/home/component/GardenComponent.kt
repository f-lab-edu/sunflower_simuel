package com.simuel.sunflower.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simuel.sunflower.feature.home.model.UiGardenPlant

@Composable
fun GardenComponent(
    plants: List<UiGardenPlant>, onPlantDetailClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(plants) { plant ->
            GardenPlantCard(
                plant = plant, onPlantDetailClick = { onPlantDetailClick(plant.plantId) })
        }
    }
}

@Preview
@Composable
private fun PreviewGardenTab() {
    GardenComponent(
        plants = listOf(
            UiGardenPlant(
                plantId = "bougainvillea-glabra",
                plantName = "Bougainvillea",
                wateringIntervalInDays = 21,
                lastWateringDateText = "Mar 16, 2025",
                plantedDateText = "Mar 16, 2025",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Paperflower_--_Bougainvillea_glabra.jpg"
            ), UiGardenPlant(
                plantId = "bougainvillea-glabra",
                plantName = "Bougainvillea",
                wateringIntervalInDays = 21,
                lastWateringDateText = "Mar 16, 2025",
                plantedDateText = "Mar 16, 2025",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Paperflower_--_Bougainvillea_glabra.jpg"
            ), UiGardenPlant(
                plantId = "bougainvillea-glabra",
                plantName = "Bougainvillea",
                wateringIntervalInDays = 21,
                lastWateringDateText = "Mar 16, 2025",
                plantedDateText = "Mar 16, 2025",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Paperflower_--_Bougainvillea_glabra.jpg"
            )
        ), onPlantDetailClick = {})
}
