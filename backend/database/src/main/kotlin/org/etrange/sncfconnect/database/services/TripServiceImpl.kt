package org.etrange.sncfconnect.database.services

import org.etrange.sncfconnect.database.entities.AccountEntity
import org.etrange.sncfconnect.database.entities.TripEntity
import org.etrange.sncfconnect.database.repositories.TripRepository
import org.etrange.sncfconnect.shared.domain.Account
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.PageResponse
import org.etrange.sncfconnect.shared.domain.Trip
import org.etrange.sncfconnect.shared.services.TripService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TripServiceImpl(private val tripRepository: TripRepository) : TripService {
    override fun getTrips(): List<Trip> {
        return tripRepository.findAll().map { it.toDomain() }
    }

    override fun getTripsPage(pageRequest: PageRequest): PageResponse<Trip> {
        val page = tripRepository.findAll(
            org.springframework.data.domain.PageRequest.of(pageRequest.page - 1, pageRequest.size)
        )
        return PageResponse(
            content = page.content.map { it.toDomain() },
            totalElements = page.totalElements,
            totalPages = page.totalPages,
            currentPage = pageRequest.page,
            pageSize = pageRequest.size
        )
    }

    override fun getTripDetails(id: Long): Trip? {
        return tripRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun addTrip(trip: Trip): Trip {
        val entity = TripEntity(
            departureDate = trip.departureDate,
            arrivalDate = trip.arrivalDate,
            departureStation = trip.departureStation,
            arrivalStation = trip.arrivalStation,
            trainNumber = trip.trainNumber,
            duration = trip.duration,
            price = trip.price,
            currency = trip.currency,
            type = trip.type,
            passenger = trip.passenger.toEntity(),
            coach = trip.coach,
            seat = trip.seat,
            co2Emission = trip.co2Emission,
            reference = trip.reference,
            purpose = trip.purpose
        )
        val savedEntity = tripRepository.save(entity)
        return savedEntity.toDomain()
    }

    override fun removeTrip(id: Long): Boolean {
        if (!tripRepository.existsById(id)) {
            return false
        }
        tripRepository.deleteById(id)
        return true
    }
}

private fun Account.toEntity(): AccountEntity = AccountEntity(
    firstName = firstName, lastName = lastName, email = email
)

private fun TripEntity.toDomain() = Trip(
    id = id ?: throw IllegalArgumentException("Trip ID cannot be null"),
    departureDate = departureDate ?: throw IllegalArgumentException("Departure date cannot be null"),
    arrivalDate = arrivalDate ?: throw IllegalArgumentException("Arrival date cannot be null"),
    departureStation = departureStation ?: throw IllegalArgumentException("Departure station cannot be null"),
    arrivalStation = arrivalStation ?: throw IllegalArgumentException("Arrival station cannot be null"),
    trainNumber = trainNumber ?: "-1",
    duration = duration ?: throw IllegalArgumentException("Duration cannot be null"),
    price = price ?: 0,
    currency = currency ?: throw IllegalArgumentException("Currency cannot be null"),
    type = type ?: throw IllegalArgumentException("Type cannot be null"),
    passenger = passenger?.toDomain() ?: throw IllegalArgumentException("Passenger cannot be null"),
    coach = coach ?: throw IllegalArgumentException("Coach cannot be null"),
    seat = seat ?: throw IllegalArgumentException("Seat cannot be null"),
    co2Emission = co2Emission ?: throw IllegalArgumentException("CO2 emission cannot be null"),
    reference = reference ?: throw IllegalArgumentException("Reference cannot be null"),
    purpose = purpose
)
