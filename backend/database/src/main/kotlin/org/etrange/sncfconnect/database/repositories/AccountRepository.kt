package org.etrange.sncfconnect.database.repositories

import org.etrange.sncfconnect.database.entities.AccountEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CrudRepository<AccountEntity, Long>, PagingAndSortingRepository<AccountEntity, Long>
