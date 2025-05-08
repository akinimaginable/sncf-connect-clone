package org.etrange.sncfconnect.screens.tickets

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TicketsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        TicketsScreenState(
            tabTitles = persistentListOf("Upcoming", "Past")
        )
    )
    val uiState: StateFlow<TicketsScreenState> = _uiState

    fun onEvent(event: TicketsScreenEvent) {
        when (event) {
            is TicketsScreenEvent.TabSelected -> {
                _uiState.update { it.copy(selectedTab = event.tabIndex) }
            }
        }
    }
}