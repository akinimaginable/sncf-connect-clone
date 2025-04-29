package org.etrange.sncfconnect

import io.ktor.client.engine.cio.CIO
import org.etrange.sncfconnect.data.HttpClientFactory
import org.etrange.sncfconnect.repositories.AccountRepository
import org.etrange.sncfconnect.screens.account.AccountViewModel

object AppGraph {
    const val BASE_URL = "http://10.0.2.2:8080/"

    val httpClient by lazy {
        HttpClientFactory.create(engine = CIO.create())
    }

    val accountRepository: AccountRepository by lazy {
        AccountRepository(client = httpClient)
    }

    val accountViewModel: AccountViewModel by lazy {
        AccountViewModel(accountRepository = accountRepository)
    }
}