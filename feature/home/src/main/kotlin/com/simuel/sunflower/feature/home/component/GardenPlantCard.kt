package com.simuel.sunflower.feature.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.simuel.sunflower.core.domain.model.GardenPlant
import com.simuel.sunflower.feature.home.model.UiGardenPlant

@Composable
fun GardenPlantCard(
    plant: UiGardenPlant,
    onPlantDetailClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                top = 26.dp,
                start = 12.dp,
                end = 12.dp,
                bottom = 26.dp
            )
            .clickable(onClick = {
                onPlantDetailClick(plant.plantId)
            }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = plant.imageUrl,
                contentDescription = plant.plantName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = plant.plantName,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Planted",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = plant.plantedDateText,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Last Watered",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = plant.lastWateringDateText,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = "water in ${plant.wateringIntervalInDays} days.",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewGardenPlantCard() {
    GardenPlantCard(
        plant = UiGardenPlant(
            wateringIntervalInDays = 21,
            lastWateringDateText = "Mar 16, 2025",
            plantedDateText = "Mar 16, 2025",
            plantId = "12345",
            plantName = "Sunflower",
            imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fi-nesslecture.com%2Fentry%2F%25E2%2580%2598%25ED%2583%259C%25EC%2596%2591%25EC%259D%2598-%25EA%25BD%2583%25E2%2580%2599-%25ED%2595%25B4%25EB%25B0%2594%25EB%259D%25BC%25EA%25B8%25B0Sunflower%25EC%259D%2598-%25EA%25BD%2583%25EB%25A7%2590-%25ED%2599%259C%25EC%259A%25A9-%25EC%259E%25AC%25EB%25B0%25B0-%25EB%25B0%25A9%25EB%25B2%2595&psig=AOvVaw3d8Xvv_Nb4oXhlOkFxPoId&ust=1742473338712000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCICP7ZWRlowDFQAAAAAdAAAAABAE"
        ), onPlantDetailClick = {})
}
