package com.simuel.sunflower.core.data.repository

import com.simuel.sunflower.core.data.source.RemoteGalleryDataSource
import com.simuel.sunflower.core.domain.model.Photo
import com.simuel.sunflower.core.domain.repository.GalleryRepository
import javax.inject.Inject

internal class GalleryRepositoryImpl @Inject constructor(
    private val remoteGalleryDataSource: RemoteGalleryDataSource
) : GalleryRepository {

    override suspend fun getCategoryPhotos(
        category: String, page: Int, pageSize: Int
    ): List<Photo> {
        return remoteGalleryDataSource.fetchPhotosByCategory(
            query = category, page = page, perPage = pageSize
        ).map { photoDto ->
            Photo(
                id = photoDto.id,
                url = photoDto.url,
                name = photoDto.name,
                userName = photoDto.userName,
                description = photoDto.description
            )
        }
    }
}
