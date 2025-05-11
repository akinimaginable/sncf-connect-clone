package org.etrange.sncfconnect.datasources

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.etrange.sncfconnect.models.Account

class LocalDataSource(private val dataStore: DataStore<Account>) {
    val accountStream: Flow<Account> = dataStore.data.map {
        Account(
            id = it.id, firstName = it.firstName, lastName =  it.lastName, email = it.email
        )
    }
}
