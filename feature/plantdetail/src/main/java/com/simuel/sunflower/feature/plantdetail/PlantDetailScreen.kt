package com.simuel.sunflower.feature.plantdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.simuel.sunflower.core.domain.model.Plant
import com.simuel.sunflower.feature.plantdetail.component.PlantDetailAppBar
import com.simuel.sunflower.feature.plantdetail.component.PlantDetailContent
import com.simuel.sunflower.feature.plantdetail.model.PlantDetailUiState

@Composable
fun PlantDetailScreen(
    plantId: String,
    onBackClick: () -> Unit,
) {
    val viewModel: PlantDetailViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(plantId) {
        viewModel.loadPlantDetail(plantId)
    }


    Box(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is PlantDetailUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is PlantDetailUiState.Success -> {
                val plant = (uiState as PlantDetailUiState.Success).plant
                PlantDetailContent(
                    plant = plant, onBackClick = onBackClick
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlantDetailContent(
    plant: Plant,
    onBackClick: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PlantDetailAppBar(
            title = plant.name,
            imageUrl = plant.imageUrl,
            onBackClick = onBackClick,
            scrollBehavior = scrollBehavior
        )

        PlantDetailContent(
            plant = plant,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 336.dp)
                .verticalScroll(scrollState)
        )
    }
}

@Preview
@Composable
fun PreviewPlantDetailScreen() {
    val previewPlant = Plant(
        plantId = "pyrus-communis",
        name = "Pear",
        description = """
            The pear tree and shrub are a species of genus Pyrus, in the family Rosaceae, bearing the pomaceous fruit 
            of the same name. Several species of pear are valued for their edible fruit and juices while others are cultivated 
            as trees.<br><br>
            (From <a href="https://en.wikipedia.org/wiki/Pear">Wikipedia</a>)
        """.trimIndent(),
        growZoneNumber = 3,
        wateringInterval = 30,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/13/More_pears.jpg"
    )

    PlantDetailContent(
        plant = previewPlant, onBackClick = {})
}
