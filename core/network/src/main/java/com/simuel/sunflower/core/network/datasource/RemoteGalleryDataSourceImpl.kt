package com.simuel.sunflower.core.network.datasource

import com.simuel.sunflower.core.data.model.PhotoDto
import com.simuel.sunflower.core.data.source.RemoteGalleryDataSource
import com.simuel.sunflower.core.network.api.UnsplashApiService
import javax.inject.Inject

internal class RemoteGalleryDataSourceImpl @Inject constructor(
    private val unsplashApiService: UnsplashApiService
) : RemoteGalleryDataSource {
    override suspend fun fetchPhotosByCategory(
        query: String,
        page: Int,
        perPage: Int
    ): List<PhotoDto> {
        return unsplashApiService.searchPhotos(
            query = query,
            page = page,
            perPage = perPage
        ).map { photo ->
            PhotoDto(
                id = photo.id,
                url = photo.urls.regular,
                name = photo.user.name,
                userName = photo.user.username,
                description = photo.description ?: photo.altDescription ?: ""
            )
        }
    }

} 
