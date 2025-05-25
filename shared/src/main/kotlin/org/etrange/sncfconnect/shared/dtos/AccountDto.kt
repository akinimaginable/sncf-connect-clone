package org.etrange.sncfconnect.shared.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(val id: Long, val firstName: String, val lastName: String, val email: String)
