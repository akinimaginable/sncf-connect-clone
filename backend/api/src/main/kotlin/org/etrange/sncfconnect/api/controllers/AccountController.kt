package org.etrange.sncfconnect.api.controllers

import org.etrange.sncfconnect.api.validators.PaginationValidator
import org.etrange.sncfconnect.shared.domain.Account
import org.etrange.sncfconnect.shared.domain.PageRequest
import org.etrange.sncfconnect.shared.dtos.AccountDto
import org.etrange.sncfconnect.shared.dtos.PageDto
import org.etrange.sncfconnect.shared.services.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/accounts")
class AccountController(private val accountService: AccountService) {
    @GetMapping
    fun getAccounts(
        @RequestParam("page", defaultValue = "1") page: Int, @RequestParam("size", defaultValue = "5") size: Int
    ): ResponseEntity<PageDto<AccountDto>> {
        PaginationValidator.validatePaginationParams(page)
        val pageSize = size.coerceAtMost(50)
        val pageRequest = PageRequest(page = page, size = pageSize)

        val accountPage = accountService.getAccountsPage(pageRequest)
        if (accountPage.content.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        }

        val paginatedAccounts = accountPage.content.map { it.toDto() }
        return ResponseEntity.ok(
            PageDto(page = page, size = pageSize, totalElements = accountPage.totalElements, content = paginatedAccounts)
        )
    }

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable id: Long): ResponseEntity<AccountDto> {
        return try {
            val account = accountService.getAccountDetails(id)
            ResponseEntity.ok(account?.toDto())
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }

    @PostMapping
    fun createAccount(@RequestBody accountDto: AccountDto): ResponseEntity<AccountDto> {
        val account = accountService.createAccount(accountDto.toDomain())
        return ResponseEntity.status(HttpStatus.CREATED).body(account.toDto())
    }

    @PutMapping("/{id}")
    fun updateAccount(@PathVariable id: Long, @RequestBody accountDto: AccountDto): ResponseEntity<AccountDto> {
        return try {
            val updatedAccount = accountService.updateAccount(accountDto.toDomain())
            ResponseEntity.ok(updatedAccount?.toDto())
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteAccount(@PathVariable id: Long): ResponseEntity<Unit> {
        return try {
            accountService.deleteAccount(id)
            ResponseEntity.noContent().build()
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }
}

fun Account.toDto(): AccountDto = AccountDto(
    id = id, firstName = firstName, lastName = lastName, email = email
)

private fun AccountDto.toDomain(): Account = Account(
    id = id, firstName = firstName, lastName = lastName, email = email
)
