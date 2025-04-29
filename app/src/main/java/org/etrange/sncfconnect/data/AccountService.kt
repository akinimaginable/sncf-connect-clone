package org.etrange.sncfconnect.data

import org.etrange.sncfconnect.dtos.AccountDto
import org.etrange.sncfconnect.models.Account

interface AccountService {
    suspend fun getAccount(id: Int): Account?
    suspend fun updateAccount(accountDto: AccountDto): Account?
}
