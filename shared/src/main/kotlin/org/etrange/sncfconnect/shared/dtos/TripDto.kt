package org.etrange.sncfconnect.shared.dtos

import kotlinx.serialization.Serializable

@Serializable
data class TripDto(
    val id: Long,
    val departureDate: String,
    val arrivalDate: String,
    val departureStation: String,
    val arrivalStation: String,
    val trainNumber: String,
    val duration: String,
    val price: Int,
    val currency: String,
    val type: String,
    val passenger: AccountDto,
    val coach: String,
    val seat: String,
    val co2Emission: Double,
    val reference: String,
    val purpose: String = "Personal"
)
