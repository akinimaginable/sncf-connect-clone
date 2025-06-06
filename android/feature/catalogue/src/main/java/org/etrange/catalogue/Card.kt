package org.etrange.catalogue

import kotlinx.serialization.Serializable

@Serializable
data class Card(val id: Long, val name: String, val illustration: String)
