package com.simuel.sunflower.feature.gallery.component

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.core.net.toUri

@Composable
fun ImageListItem(
    name: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Card(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, imageUrl.toUri())
            context.startActivity(intent)
        },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 26.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "plants image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = name,
                textAlign = TextAlign.Center,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewImageListItem() {
    ImageListItem(
        name = "sunflower", imageUrl = "https://unsplash.com/plant.jpg", onClick = {})
}
