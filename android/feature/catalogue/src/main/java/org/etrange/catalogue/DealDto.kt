package org.etrange.catalogue

import kotlinx.serialization.Serializable

@Serializable
data class DealDto(val id: Long, val name: String, val illustration: String, val logo: String)

fun DealDto.toModel(): Deal {
    return Deal(
        id = id,
        name = name,
        illustration = illustration,
        logo = logo
    )
}
