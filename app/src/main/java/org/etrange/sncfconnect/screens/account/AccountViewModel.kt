package org.etrange.sncfconnect.screens.account

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.etrange.sncfconnect.models.Account

class AccountViewModel : ViewModel() {
    private val account = Account(firstname = "Jeanne", lastName = "Doe")
    private val _uiState = MutableStateFlow<AccountState>(
        AccountState(
            fullName = "${account.firstname} ${account.lastName}",
            initial = "${account.firstname.first()}${account.lastName.first()}".uppercase()
        )
    )

    val uiState: StateFlow<AccountState> = _uiState.asStateFlow()
}
