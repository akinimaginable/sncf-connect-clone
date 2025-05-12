package org.etrange.account

import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(val id: Long, val firstName: String, val lastName: String, val email: String)

fun AccountDto.toModel(): Account {
    return Account(
        id = this.id, firstName = this.firstName, lastName = this.lastName, email = this.email
    )
}
