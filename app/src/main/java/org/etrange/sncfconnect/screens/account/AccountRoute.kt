package org.etrange.sncfconnect.screens.account

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.etrange.sncfconnect.AppGraph

@Composable
fun AccountRoute(
    innerPadding: PaddingValues,
    viewModel: AccountViewModel = remember { AppGraph.accountViewModel }
) {
    val state: AccountState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onEvent(AccountEvent.GetAccount(1))
    }

    AccountScreen(
        innerPadding = innerPadding, state = state, onEvent = viewModel::onEvent
    )
}
