package org.etrange.sncfconnect.database.services

import org.etrange.sncfconnect.database.entities.OfferEntity
import org.etrange.sncfconnect.database.repositories.OfferRepository
import org.etrange.sncfconnect.shared.domain.Offer
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.PageResponse
import org.etrange.sncfconnect.shared.services.OfferService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OfferServiceImpl(private val offerRepository: OfferRepository) : OfferService {
    override fun getOffers(): List<Offer> {
        return offerRepository.findAll().map { it.toDomain() }
    }

    override fun getOffersPage(pageRequest: PageRequest): PageResponse<Offer> {
        // Convert to Spring PageRequest - this keeps Spring Data dependencies in the service layer
        val springPageable = org.springframework.data.domain.PageRequest.of(pageRequest.page - 1, pageRequest.size)
        val offerPage = offerRepository.findAll(springPageable)

        return PageResponse(
            content = offerPage.content.map { it.toDomain() },
            totalElements = offerPage.totalElements,
            totalPages = offerPage.totalPages,
            currentPage = pageRequest.page,
            pageSize = pageRequest.size
        )
    }

    override fun getOfferDetails(id: Long): Offer? {
        return offerRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun addOffer(offer: Offer): Offer {
        val entity = OfferEntity(
            name = offer.name,
            altText = offer.altText,
            illustration = offer.illustration,
            price = offer.price,
            discount = offer.discount
        )
        val savedEntity = offerRepository.save(entity)
        return savedEntity.toDomain()
    }

    override fun removeOffer(id: Long): Boolean {
        if (!offerRepository.existsById(id)) {
            return false
        }
        offerRepository.deleteById(id)
        return true
    }
}

private fun OfferEntity.toDomain(): Offer {
    return Offer(
        id = id ?: throw IllegalStateException("Offer ID cannot be null"),
        name = name ?: "",
        altText = altText ?: "",
        illustration = illustration ?: "",
        price = price,
        discount = discount
    )
}
