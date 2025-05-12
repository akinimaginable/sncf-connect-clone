package org.etrange.account

class AccountRepository(
    // private val localDataSource: LocalDataSource,
    private val remoteDataSource: KtorAccountDataSource
) : AccountService {
    override suspend fun getAccount(id: Int): Account? {
        remoteDataSource.getAccount(id)?.let { account ->
            return account
        }

        return null
    }

    override suspend fun updateAccount(accountDto: AccountDto): Account? {
        TODO("Not yet implemented")
    }
}