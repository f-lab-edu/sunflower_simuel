package com.simuel.sunflower.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.simuel.sunflower.core.domain.model.Plant
import com.simuel.sunflower.feature.home.component.GardenPlantGrid
import com.simuel.sunflower.feature.home.component.MainTopBar
import com.simuel.sunflower.feature.home.component.PlantListGrid
import com.simuel.sunflower.feature.home.model.UiGardenPlant

@Composable
fun HomeScreen(
    onPlantDetailClick: (String) -> Unit,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.loadPlants()
        viewModel.loadGardenPlants()
    }

    val selectedTabIndex by viewModel.selectedTabIndex.collectAsStateWithLifecycle()
    val gardenPlants by viewModel.gardenPlants.collectAsStateWithLifecycle()
    val plants by viewModel.plants.collectAsStateWithLifecycle()

    HomeScreen(
        selectedTabIndex = selectedTabIndex,
        onTabSelected = viewModel::updateSelectedTabIndex,
        gardenPlants = gardenPlants,
        plants = plants,
        onPlantDetailClick = onPlantDetailClick
    )
}

@Composable
private fun HomeScreen(
    selectedTabIndex: Int,
    gardenPlants: List<UiGardenPlant>,
    plants: List<Plant>,
    onTabSelected: (Int) -> Unit,
    onPlantDetailClick: (String) -> Unit
) {
    val tabs = listOf("Garden", "Plant List")

    Scaffold(
        topBar = { MainTopBar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = selectedTabIndex == index,
                        onClick = { onTabSelected(index) })
                }
            }

            when (selectedTabIndex) {
                0 -> GardenPlantGrid(
                    plants = gardenPlants,
                    onPlantDetailClick = onPlantDetailClick
                )

                1 -> PlantListGrid(
                    plants = plants,
                    onPlantDetailClick = onPlantDetailClick
                )
            }
        }
    }
}

@Preview(name = "gardenTab", showBackground = true)
@Composable
private fun PreviewHomeScreenGreenTab() {
    HomeScreen(
        selectedTabIndex = 0,
        onTabSelected = { },
        gardenPlants = listOf(
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
        ),
        plants = listOf(),
        onPlantDetailClick = { }
    )
}


@Preview(name = "PlantListTab", showBackground = true)
@Composable
private fun PreviewHomeScreenPlantListTab() {
    HomeScreen(
        selectedTabIndex = 1,
        onTabSelected = { },
        gardenPlants = listOf(),
        plants = listOf(
            Plant(
                plantId = "helianthus-annuus",
                name = "Sunflower",
                description = """
            Roses are red<br>
            Violets are blue<br>
            Sunflowers have seeds<br>
            That folks love to chew<br><br>
            - M.G., 2018<br><br>
            Helianthus annuus, the common sunflower, is a large annual forb of the genus Helianthus grown as a crop for its 
            edible oil and edible fruits. This sunflower species is also used as wild bird food, as livestock forage (as a meal 
            or a silage plant), in some industrial applications, and as an ornamental in domestic gardens. The plant was first 
            domesticated in the Americas. Wild Helianthus annuus is a widely branched annual plant with many flower heads. 
            The domestic sunflower, however, often possesses only a single large inflorescence (flower head) atop an unbranched stem. 
            The name sunflower may derive from the flower's head's shape, which resembles the sun, or from the impression that 
            the blooming plant appears to slowly turn its flower towards the sun as the latter moves across the sky on a daily basis.<br><br>
            Sunflower seeds were brought to Europe from the Americas in the 16th century, where, along with sunflower oil, 
            they became a widespread cooking ingredient.<br><br>
            (From <a href="https://en.wikipedia.org/wiki/Helianthus_annuus">Wikipedia</a>)
        """.trimIndent(),
                growZoneNumber = 8,
                wateringInterval = 3,
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/aa/Sunflowers_in_field_flower.jpg"
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
        ),
        onPlantDetailClick = { }
    )
}
