package org.etrange.sncfconnect.shared.services

import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.PageResponse
import org.etrange.sncfconnect.shared.domain.Trip

interface TripService {
    fun getTrips(): List<Trip>
    fun getTripsPage(pageRequest: PageRequest): PageResponse<Trip>
    fun getTripDetails(id: Long): Trip?
    fun addTrip(trip: Trip): Trip
    fun removeTrip(id: Long): Boolean
}
