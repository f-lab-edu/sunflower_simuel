package com.simuel.sunflower.core.data.source

import com.simuel.sunflower.core.data.model.PhotoDto

interface RemoteGalleryDataSource {
    suspend fun fetchImagesByCategory(
        query: String,
        page: Int,
        perPage: Int
    ): List<PhotoDto>
}
