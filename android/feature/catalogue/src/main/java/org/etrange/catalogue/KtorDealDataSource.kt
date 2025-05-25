package org.etrange.catalogue

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KtorDealDataSource(private val client: HttpClient, private val url: String) :
    CatalogueService<Card> {
    override suspend fun get(): List<Card>? {
        return withContext(Dispatchers.IO) {
            val response = try {
                client.get(urlString = "${url}/catalogue")
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
                response.body<List<CardDto>>()
            } catch (e: Exception) {
                println("Error: ${e.message}")
                return@withContext null
            }

            return@withContext body.map { it.toModel() }
        }
    }
}
