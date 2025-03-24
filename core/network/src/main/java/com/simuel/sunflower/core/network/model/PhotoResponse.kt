package com.simuel.sunflower.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoResponse(
    @SerialName("id") val id: String,
    @SerialName("urls") val urls: PhotoUrls,
    @SerialName("user") val user: UnsplashUser,
    @SerialName("description") val description: String? ,
    @SerialName("alt_description") val altDescription: String?,
) 
