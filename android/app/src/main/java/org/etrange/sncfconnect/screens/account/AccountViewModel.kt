package org.etrange.sncfconnect.screens.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.etrange.account.AccountRepository
import org.etrange.sncfconnect.shared.dtos.AccountDto

class AccountViewModel(private val repository: AccountRepository) : ViewModel() {
    private var _uiState = MutableStateFlow<AccountState>(AccountState())
    val uiState: StateFlow<AccountState> = _uiState.asStateFlow()

    fun onEvent(event: AccountEvent) {
        when (event) {
            is AccountEvent.GetAccount -> fetchAccount(event.id)
            is AccountEvent.UpdateAccount -> updateAccount(event.accountDto)
        }
    }

    private fun fetchAccount(id: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val account = repository.getAccount(id)
                // Update with success state
                _uiState.value = _uiState.value.copy(
                    account = account,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                // Handle error state
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error occurred"
                )
            }
        }
    }

    private fun updateAccount(accountDto: AccountDto) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val updatedAccount = repository.updateAccount(accountDto)
                _uiState.value = _uiState.value.copy(
                    account = updatedAccount,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to update account"
                )
            }
        }
    }
}
