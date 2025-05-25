package org.etrange.sncfconnect.shared.services

import org.etrange.sncfconnect.shared.domain.Account
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.PageResponse

interface AccountService {
    fun getAccounts(): List<Account>
    fun getAccountsPage(pageRequest: PageRequest): PageResponse<Account>
    fun getAccountDetails(id: Long): Account?
    fun createAccount(account: Account): Account
    fun updateAccount(account: Account): Account?
    fun deleteAccount(id: Long): Boolean
}
