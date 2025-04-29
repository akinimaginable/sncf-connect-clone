package org.etrange.sncfconnect.dtos

import kotlinx.serialization.Serializable
import org.etrange.sncfconnect.models.Account

@Serializable
data class AccountDto(val id: Long, val firstName: String, val lastName: String, val email: String)

fun AccountDto.toModel(): Account {
    return Account(
        id = this.id, firstName = this.firstName, lastName = this.lastName, email = this.email
    )
}
