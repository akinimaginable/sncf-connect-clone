package org.etrange.sncfconnect.shared.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PageDto<T>(
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int = (totalElements / size).toInt() + if (totalElements % size > 0) 1 else 0,
    val content: List<T>,
)
