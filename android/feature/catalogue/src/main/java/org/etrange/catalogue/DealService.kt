package org.etrange.catalogue

interface DealService {
    suspend fun getDeals(): List<Deal>
}