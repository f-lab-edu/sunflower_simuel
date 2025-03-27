package com.simuel.sunflower.core.network.api

import com.simuel.sunflower.core.network.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UnsplashApiService {
    @GET("photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<PhotoResponse>
} 
