package com.simuel.sunflower.core.domain.repository

import com.simuel.sunflower.core.domain.model.Photo

interface GalleryRepository {
    suspend fun getCategoryImages(
        category: String,
        page: Int,
        pageSize: Int
    ): List<Photo>
}
