package org.etrange.account

interface AccountService {
    suspend fun getAccount(id: Int): Account?
    suspend fun updateAccount(accountDto: AccountDto): Account?
}
