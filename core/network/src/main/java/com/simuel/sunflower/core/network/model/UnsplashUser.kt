package com.simuel.sunflower.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UnsplashUser(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String,
    @SerialName("name") val name: String,
    @SerialName("links") val links: UnsplashUserLinks
) 
