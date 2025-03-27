package com.simuel.sunflower.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UnsplashUserLinks(
    @SerialName("html") val html: String
) 
