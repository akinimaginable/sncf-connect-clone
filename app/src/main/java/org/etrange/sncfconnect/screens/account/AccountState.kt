package org.etrange.sncfconnect.screens.account

import androidx.compose.runtime.Stable
import org.etrange.account.Account

@Stable
data class AccountState(
    val account: Account? = null,
    var isLoading: Boolean = false,
    val error: String? = null,
    var isAnnouncementEnabled: Boolean = false,
) {
    val fullName: String get() = "${account?.firstName ?: ""} ${account?.lastName ?: ""}"
    val initials: String get() = "${account?.firstName?.firstOrNull() ?: "N"}${account?.lastName?.firstOrNull() ?: "A"}"
}
