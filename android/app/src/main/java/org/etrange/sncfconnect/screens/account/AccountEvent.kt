package org.etrange.sncfconnect.screens.account

import org.etrange.sncfconnect.shared.dtos.AccountDto

sealed interface AccountEvent {
    data class GetAccount(val id: Int) : AccountEvent
    data class UpdateAccount(val accountDto: AccountDto)
}
