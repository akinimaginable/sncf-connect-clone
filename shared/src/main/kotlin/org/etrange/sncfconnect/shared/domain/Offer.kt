package org.etrange.sncfconnect.shared.domain

data class Offer(
    val id: Long, val name: String, val altText: String, val illustration: String, val price: Int?, val discount: Int?
)
