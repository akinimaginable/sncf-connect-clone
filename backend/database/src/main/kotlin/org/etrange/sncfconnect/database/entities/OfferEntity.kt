package org.etrange.sncfconnect.database.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class OfferEntity(
    @Id @GeneratedValue val id: Long? = null,
    val name: String? = "null",
    val altText: String? = null,
    val illustration: String? = null,
    val price: Int? = null,
    val discount: Int? = null
) {
    protected constructor() : this(null)
}
