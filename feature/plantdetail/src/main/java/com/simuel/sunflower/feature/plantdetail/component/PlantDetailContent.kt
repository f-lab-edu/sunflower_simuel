package com.simuel.sunflower.feature.plantdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import com.simuel.sunflower.core.domain.model.Plant

@Composable
fun PlantDetailContent(
    plant: Plant,
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Watering needs",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "every ${plant.wateringInterval} days",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        val description =
            HtmlCompat.fromHtml(plant.description, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
