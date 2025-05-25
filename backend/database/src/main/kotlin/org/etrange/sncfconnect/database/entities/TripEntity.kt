package org.etrange.sncfconnect.database.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class TripEntity(
    @Id @GeneratedValue val id: Long? = null,
    val departureDate: String? = null,
    val arrivalDate: String? = null,
    val departureStation: String? = null,
    val arrivalStation: String? = null,
    val trainNumber: String? = null,
    val duration: String? = null,
    val price: Int? = null,
    val currency: String? = null,
    val type: String? = null,
    @ManyToOne var passenger: AccountEntity? = null,
    val coach: String? = null,
    val seat: String? = null,
    val co2Emission: Double? = null,
    val reference: String? = null,
    val purpose: String = "Personal"
) {
    protected constructor() : this(null)
}
