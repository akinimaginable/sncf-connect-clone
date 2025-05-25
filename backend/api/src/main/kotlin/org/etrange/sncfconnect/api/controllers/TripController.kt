package org.etrange.sncfconnect.api.controllers

import org.etrange.sncfconnect.api.validators.PaginationValidator
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.Trip
import org.etrange.sncfconnect.shared.dtos.PageDto
import org.etrange.sncfconnect.shared.dtos.TripDto
import org.etrange.sncfconnect.shared.services.TripService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/trips")
class TripController(private val tripService: TripService) {
    @GetMapping
    fun getTrips(
        @RequestParam("page", defaultValue = "1") page: Int, @RequestParam("size", defaultValue = "5") size: Int
    ): ResponseEntity<PageDto<TripDto>> {
        PaginationValidator.validatePaginationParams(page)
        val pageSize = size.coerceAtMost(50)
        val pageable: PageRequest = PageRequest(page - 1, pageSize)

        val tripPage = tripService.getTripsPage(pageable)
        if (tripPage.content.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        }

        val paginatedTrips = tripPage.content.map { it.toDto() }
        return ResponseEntity.ok(
            PageDto(page = page, size = pageSize, totalElements = tripPage.totalElements, content = paginatedTrips)
        )
    }

    @GetMapping("/{id}")
    fun getTripById(@PathVariable id: Long): ResponseEntity<TripDto> {
        return try {
            val trip = tripService.getTripDetails(id)
            ResponseEntity.ok(trip?.toDto())
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }
}

private fun Trip.toDto(): TripDto = TripDto(
    id = this.id,
    departureDate = this.departureDate,
    arrivalDate = this.arrivalDate,
    departureStation = this.departureStation,
    arrivalStation = this.arrivalStation,
    trainNumber = this.trainNumber,
    duration = this.duration,
    price = this.price,
    currency = this.currency,
    type = this.type,
    passenger = this.passenger.toDto(),
    coach = this.coach,
    seat = this.seat,
    co2Emission = this.co2Emission,
    reference = this.reference,
    purpose = this.purpose
)
