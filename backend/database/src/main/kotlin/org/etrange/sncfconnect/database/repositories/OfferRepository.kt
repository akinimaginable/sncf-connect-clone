package org.etrange.sncfconnect.database.repositories

import org.etrange.sncfconnect.database.entities.OfferEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface OfferRepository : CrudRepository<OfferEntity, Long>, PagingAndSortingRepository<OfferEntity, Long>
