package org.etrange.sncfconnect.api.validators

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

object PaginationValidator {
    /**
     * Validates pagination parameters
     * @param page The requested page number
     * @throws org.springframework.web.server.ResponseStatusException if parameters are invalid
     */
    fun validatePaginationParams(page: Int) {
        if (page < 1) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Page must be positive"
            )
        }
    }
}