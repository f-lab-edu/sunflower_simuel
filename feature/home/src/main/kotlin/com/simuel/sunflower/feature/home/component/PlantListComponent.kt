package com.simuel.sunflower.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simuel.sunflower.core.domain.model.Plant

@Composable
fun PlantListComponent(
    plants: List<Plant>,
    onPlantDetailClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(plants) { plant ->
            PlantCard(
                plant = plant,
                onPlantDetailClick = { onPlantDetailClick(plant.plantId) }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewPlantListComponent() {
    PlantListComponent(
        plants = listOf(
            Plant(
                plantId = "aquilegia-coerulea",
                name = "Sunflower",
                description = """
            Aquilegia coerulea, the state flower of Colorado, is a species of flowering plant in the buttercup family Ranunculaceae, 
            native to the Rocky Mountains from Montana south to New Mexico and west to Idaho and Arizona. Its common name is 
            Colorado blue columbine; sometimes it is called "Rocky Mountain columbine," but this also refers to Aquilegia saximontana.<br><br>
            (From <a href="https://en.wikipedia.org/wiki/Aquilegia_coerulea">Wikipedia</a>)
        """.trimIndent(),
                growZoneNumber = 5,
                wateringInterval = 3,
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/94/Aquilegia_caerulea.jpg"
            ), Plant(
                plantId = "magnolia-denudata",
                name = "Yulan Magnolia",
                description = """
            Magnolia denudata, known as the lilytree or Yulan magnolia (simplified Chinese: 玉兰花; traditional Chinese: 玉蘭花), 
            is native to central and eastern China. It has been cultivated in Chinese Buddhist temple gardens since 600 AD. 
            Its flowers were regarded as a symbol of purity in the Tang Dynasty and it was planted in the grounds of the Emperor's palace.<br><br>
            It is the official city flower of Shanghai.<br><br>
            (From <a href="https://en.wikipedia.org/wiki/Magnolia_denudata">Wikipedia</a>)
        """.trimIndent(),
                growZoneNumber = 8,
                wateringInterval = 7,
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/13/Yulan_magnolia_%28Magnolia_denudata%29_%2816953983745%29.jpg"
            ), Plant(
                plantId = "bougainvillea-glabra",
                name = "Bougainvillea",
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
            )
        ), onPlantDetailClick = {})
}
