package org.etrange.catalogue

import kotlinx.serialization.Serializable

@Serializable
data class Deal(val id: Long, val name: String, val illustration: String, val logo: String)
