package org.etrange.account

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.etrange.sncfconnect.shared.domain.Account
import org.etrange.sncfconnect.shared.dtos.AccountDto

class KtorAccountDataSource(private val client: HttpClient, private val url: String) :
    AccountService {
    override suspend fun getAccount(id: Int): Account? {
        return withContext(Dispatchers.IO) {
            val response = try {
                client.get(urlString = "$url/accounts/$id")
            } catch (e: Exception) {
                println("Error: ${e.message}")
                return@withContext null
            }

            if (response.status.value >= 400) {
                println("Error: ${response.status}")
                return@withContext null
            }

            val dto = try {
                response.body<AccountDto>()
            } catch (e: Exception) {
                println("Error: ${e.message}")
                return@withContext null
            }

            return@withContext dto.toModel()
        }
    }

    override suspend fun updateAccount(accountDto: AccountDto): Account? {
        TODO("Not yet implemented")
    }
}

fun AccountDto.toModel(): Account {
    return Account(
        id = this.id, firstName = this.firstName, lastName = this.lastName, email = this.email
    )
}
