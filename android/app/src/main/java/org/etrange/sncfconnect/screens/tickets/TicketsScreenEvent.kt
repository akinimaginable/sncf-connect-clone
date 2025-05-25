package org.etrange.sncfconnect.screens.tickets

sealed class TicketsScreenEvent {
    data class TabSelected(val tabIndex: Int) : TicketsScreenEvent()
}
