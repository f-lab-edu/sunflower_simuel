package com.simuel.sunflower.core.data.repository

import com.simuel.sunflower.core.data.model.PhotoDto
import com.simuel.sunflower.core.data.source.RemoteGalleryDataSource
import com.simuel.sunflower.core.domain.model.Photo
import com.simuel.sunflower.core.domain.repository.GalleryRepository
import javax.inject.Inject

internal class GalleryRepositoryImpl @Inject constructor(
    private val remoteGalleryDataSource: RemoteGalleryDataSource
) : GalleryRepository {
    
    override suspend fun getCategoryImages(
        category: String, 
        page: Int, 
        pageSize: Int
    ): List<Photo> {
        return remoteGalleryDataSource.fetchImagesByCategory(
            query = category,
            page = page,
            perPage = pageSize
        ).map { photoDto ->
            photoDto.toDomainModel()
        }
    }
    
    private fun PhotoDto.toDomainModel(): Photo {
        return Photo(
            id = id,
            url = url,
            name = name,
            userName = userName,
            description = description
        )
    }
}
