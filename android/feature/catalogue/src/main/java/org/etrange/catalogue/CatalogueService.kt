package org.etrange.catalogue

interface CatalogueService<T> {
    suspend fun get(): List<T>?
}
