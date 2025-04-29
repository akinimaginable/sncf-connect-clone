package org.etrange.sncfconnect.repositories

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import org.etrange.sncfconnect.AppGraph
import org.etrange.sncfconnect.data.AccountService
import org.etrange.sncfconnect.dtos.AccountDto
import org.etrange.sncfconnect.dtos.toModel
import org.etrange.sncfconnect.models.Account

class AccountRepository(private val client: HttpClient) : AccountService {
    override suspend fun getAccount(id: Int): Account? {
        println("Fetching account with ID: $id")
        val response = try {
            client.get(urlString = "${AppGraph.BASE_URL}accounts/${id}")
        } catch (e: UnresolvedAddressException) {
            println("Error: ${e.message}")
            return null
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return null
        }

        if (response.status.value >= 400) {
            println("Error: ${response.status}")
            return null
        }

        val body = try {
            response.body<AccountDto>()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return null
        }

        return body.toModel()
    }

    override suspend fun updateAccount(accountDto: AccountDto): Account? {
        TODO("Not yet implemented")
    }
}
