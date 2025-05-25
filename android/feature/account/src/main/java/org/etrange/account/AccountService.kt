package org.etrange.account

import org.etrange.sncfconnect.shared.domain.Account
import org.etrange.sncfconnect.shared.dtos.AccountDto

interface AccountService {
    suspend fun getAccount(id: Int): Account?
    suspend fun updateAccount(accountDto: AccountDto): Account?
}
