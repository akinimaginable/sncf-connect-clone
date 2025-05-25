package org.etrange.sncfconnect.shared.services

import org.etrange.sncfconnect.shared.domain.Offer
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.PageResponse

interface OfferService {
    fun getOffers(): List<Offer>
    fun getOffersPage(pageRequest: PageRequest): PageResponse<Offer>
    fun getOfferDetails(id: Long): Offer?
    fun addOffer(offer: Offer): Offer
    fun removeOffer(id: Long): Boolean
}
