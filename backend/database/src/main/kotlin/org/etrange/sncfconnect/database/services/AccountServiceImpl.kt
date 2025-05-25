package org.etrange.sncfconnect.database.services

import org.etrange.sncfconnect.database.entities.AccountEntity
import org.etrange.sncfconnect.database.repositories.AccountRepository
import org.etrange.sncfconnect.shared.domain.Account
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.domain.PageResponse
import org.etrange.sncfconnect.shared.services.AccountService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest as SpringPageRequest

@Service
class AccountServiceImpl(private val accountRepository: AccountRepository) : AccountService {
    override fun getAccounts(): List<Account> {
        return accountRepository.findAll().map { it.toDomain() }
    }

    override fun getAccountsPage(pageRequest: PageRequest): PageResponse<Account> {
        // Convert to Spring PageRequest - this keeps Spring Data dependencies in the service layer
        val springPageable = SpringPageRequest.of(pageRequest.page - 1, pageRequest.size)
        val accountPage = accountRepository.findAll(springPageable)

        return PageResponse(
            content = accountPage.content.map { it.toDomain() },
            totalElements = accountPage.totalElements,
            totalPages = accountPage.totalPages,
            currentPage = pageRequest.page,
            pageSize = pageRequest.size
        )
    }

    override fun getAccountDetails(id: Long): Account? {
        return accountRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun createAccount(account: Account): Account {
        val entity = AccountEntity(
            firstName = account.firstName, lastName = account.lastName, email = account.email
        )
        val savedEntity = accountRepository.save(entity)
        return savedEntity.toDomain()
    }

    override fun updateAccount(account: Account): Account? {
        val entity = accountRepository.findByIdOrNull(account.id) ?: return null
        val updatedEntity = AccountEntity(
            id = entity.id, firstName = account.firstName, lastName = account.lastName, email = account.email
        )

        accountRepository.save<AccountEntity>(updatedEntity)
        return updatedEntity.toDomain()
    }

    override fun deleteAccount(id: Long): Boolean {
        if (!accountRepository.existsById(id)) {
            return false
        }
        accountRepository.deleteById(id)
        return true
    }
}

fun AccountEntity.toDomain(): Account = Account(
    id = id ?: throw IllegalStateException("Account ID cannot be null"),
    firstName = firstName ?: "",
    lastName = lastName ?: "",
    email = email ?: ""
)
