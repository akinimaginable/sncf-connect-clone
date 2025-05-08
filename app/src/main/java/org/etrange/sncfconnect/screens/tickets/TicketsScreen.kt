package org.etrange.sncfconnect.screens.tickets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun TicketsScreen(
    innerPadding: PaddingValues,
    viewModel: TicketsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    TicketsScreenContent(
        innerPadding = innerPadding, state = state, onEvent = viewModel::onEvent
    )
}
