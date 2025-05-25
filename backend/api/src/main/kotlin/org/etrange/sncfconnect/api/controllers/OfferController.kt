package org.etrange.sncfconnect.api.controllers

import org.etrange.sncfconnect.shared.dtos.OfferDto
import org.etrange.sncfconnect.api.validators.PaginationValidator
import org.etrange.sncfconnect.shared.domain.Offer
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.dtos.PageDto
import org.etrange.sncfconnect.shared.services.OfferService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/offers")
class OfferController(private val offerService: OfferService) {
    @GetMapping
    fun getOffers(
        @RequestParam("page", defaultValue = "1") page: Int, @RequestParam("size", defaultValue = "5") size: Int
    ): ResponseEntity<PageDto<OfferDto>> {
        PaginationValidator.validatePaginationParams(page)
        val pageSize = size.coerceAtMost(50)
        val pageRequest = PageRequest(page = page, size = pageSize)

        val offersPage = offerService.getOffersPage(pageRequest)
        if (offersPage.content.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        }

        val paginatedOffers = offersPage.content.map { it.toDto() }
        return ResponseEntity.ok(
            PageDto(page = page, size = pageSize, totalElements = offersPage.totalElements, content = paginatedOffers)
        )
    }

    @GetMapping("/{id}")
    fun getOfferById(@PathVariable id: Long): ResponseEntity<OfferDto> {
        return try {
            val offer = offerService.getOfferDetails(id)
            ResponseEntity.ok(offer?.toDto())
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }
}

private fun Offer.toDto(): OfferDto = OfferDto(
    id = id, name = name, altText = altText, illustration = illustration, price = price, discount = discount
)
