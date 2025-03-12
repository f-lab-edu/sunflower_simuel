package com.simuel.sunflower.feature.plantdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlantDetailScreen(
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            PlantDetailTopBar(
                title = "PlantDetail 화면",
                onBackClick = onBackClick
            )
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "PlantDetail 화면",
                style = MaterialTheme.typography.headlineMedium
            )


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantDetailTopBar(
    title: String, onBackClick: () -> Unit
) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
    }, navigationIcon = {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back"
            )
        }
    })
}

@Preview
@Composable
fun PreviewPlantDetailScreen() {
    PlantDetailScreen(
       onBackClick = {})
} 