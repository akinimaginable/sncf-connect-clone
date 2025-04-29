package org.etrange.sncfconnect.screens.account

import androidx.compose.runtime.Stable
import org.etrange.sncfconnect.models.Account

@Stable
data class AccountState(val account: Account? = null, var isLoading: Boolean = true) {
    val initial: String
        get() = "${account?.firstName?.firstOrNull() ?: ""}${account?.lastName?.firstOrNull() ?: ""}".uppercase()
    val fullName: String
        get() = "${account?.firstName} ${account?.lastName}"
}
