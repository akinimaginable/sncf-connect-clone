package org.etrange.sncfconnect.screens.tickets

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class TicketsScreenState(
    val selectedTab: Int = 0, val tabTitles: PersistentList<String> = persistentListOf()
)
