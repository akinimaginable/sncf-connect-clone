package org.etrange.sncfconnect.screens.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.etrange.sncfconnect.repositories.AccountRepository

class AccountViewModel(private val repository: AccountRepository) : ViewModel() {
    private var _uiState = MutableStateFlow<AccountState>(AccountState())
    val uiState: StateFlow<AccountState> = _uiState.asStateFlow()

    fun onEvent(event: AccountEvent) {
        when (event) {
            is AccountEvent.GetAccount -> {
                viewModelScope.launch {
                    _uiState.value = _uiState.value.copy(
                        account = repository.getAccount(event.id),
                    )
                }
            }

            is AccountEvent.UpdateAccount -> {
                viewModelScope.launch {
                    _uiState.value = _uiState.value.copy(
                        account = repository.updateAccount(event.accountDto),
                    )
                }
            }
        }
    }
}
