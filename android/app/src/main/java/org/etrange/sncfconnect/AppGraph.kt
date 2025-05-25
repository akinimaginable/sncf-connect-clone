package org.etrange.sncfconnect

import io.ktor.client.engine.cio.CIO
import org.etrange.account.AccountRepository
import org.etrange.account.KtorAccountDataSource
import org.etrange.sncfconnect.screens.account.AccountViewModel

object AppGraph {
    const val BASE_URL = "http://10.0.2.2:8080"

    val httpClient by lazy {
        HttpClientFactory.create(engine = CIO.create())
    }

    val ktorAccountDataSource by lazy {
        KtorAccountDataSource(client = httpClient, url = BASE_URL)
    }

    // val localDataSource by lazy { LocalDataSource(dataStore = App.instance.dataStore)}

    val accountRepository: AccountRepository = AccountRepository(
        // localDataSource = localDataSource,
        remoteDataSource = ktorAccountDataSource
    )

    val accountViewModel: AccountViewModel by lazy {
        AccountViewModel(repository = accountRepository)
    }
}
