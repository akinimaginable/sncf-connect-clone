package org.etrange.catalogue

import kotlinx.serialization.Serializable

@Serializable
data class CardDto(val id: Long, val name: String, val illustration: String)

fun CardDto.toModel(): Card {
    return Card(
        id = id,
        name = name,
        illustration = illustration
    )
}
