package org.etrange.sncfconnect.database.repositories

import org.etrange.sncfconnect.database.entities.TripEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TripRepository : CrudRepository<TripEntity, Long>, PagingAndSortingRepository<TripEntity, Long>
