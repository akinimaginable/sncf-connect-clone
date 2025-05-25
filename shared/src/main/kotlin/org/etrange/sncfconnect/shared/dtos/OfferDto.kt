package org.etrange.sncfconnect.shared.dtos

import kotlinx.serialization.Serializable

@Serializable
data class OfferDto(
    val id: Long,
    val name: String,
    val altText: String,
    val illustration: String,
    val price: Int?,
    val discount: Int?
)