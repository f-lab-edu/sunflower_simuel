package com.simuel.sunflower.feature.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.simuel.sunflower.core.domain.model.Plant

@Composable
fun PlantCard(
    plant: Plant,
    onPlantDetailClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 12.dp,
                vertical = 26.dp
            )
            .clickable(onClick = { onPlantDetailClick(plant.plantId) }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            AsyncImage(
                model = plant.imageUrl,
                contentDescription = plant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = plant.name,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewPlantCard() {
    PlantCard(
        plant = Plant(
            plantId = "bougainvillea-glabra",
            name = "Rocky Mountain Columbine",
            description = """
            Bougainvillea is a genus of thorny ornamental vines, bushes, or trees. The inflorescence consists of large colourful 
            sepallike bracts which surround three simple waxy flowers. The vine species grow anywhere from 1 to 12 m (3 to 40 ft.) 
            tall, scrambling over other plants with their spiky thorns, which are tipped with a black, waxy substance. They are 
            evergreen where rainfall occurs all year, or deciduous if there is a dry season.<br><br>
            Bougainvillea glabra (simplified Chinese: 簕杜鹃; traditional Chinese: 簕杜鵑) is the official city flower of Shenzhen 
            and many other cities around the world.<br><br>
            (From <a href="https://en.wikipedia.org/wiki/Bougainvillea">Wikipedia</a>)
        """.trimIndent(),
            growZoneNumber = 10,
            wateringInterval = 21,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Paperflower_--_Bougainvillea_glabra.jpg"
        ), onPlantDetailClick = {})
}
