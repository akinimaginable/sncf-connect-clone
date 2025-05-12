package org.etrange.account

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KtorAccountDataSource(private val client: HttpClient, private val url: String) :
    AccountService {
    override suspend fun getAccount(id: Int): Account? {
        return withContext(Dispatchers.IO) {
            val response = try {
                client.get(urlString = "${url}/accounts/${id}")
            } catch (e: Exception) {
                println("Error: ${e.message}")
                return@withContext null
            }

            response.status.value.let {
                if (it >= 400) {
                    println("Error: ${response.status}")
                    return@withContext null
                }
            }

            val body = try {
                response.body<AccountDto>()
            } catch (e: Exception) {
                println("Error: ${e.message}")
                return@withContext null
            }

            return@withContext body.toModel()
        }
    }

    override suspend fun updateAccount(accountDto: AccountDto): Account? {
        TODO("Not yet implemented")
    }
}