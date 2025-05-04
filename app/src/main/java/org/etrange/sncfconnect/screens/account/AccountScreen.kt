package org.etrange.sncfconnect.screens.account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.models.Account
import org.etrange.sncfconnect.ui.components.IllustratedCard
import org.etrange.sncfconnect.ui.components.MuchMoreThanATrain
import org.etrange.sncfconnect.ui.components.NeedHelpView
import org.etrange.sncfconnect.ui.theme.DarkBlue
import org.etrange.sncfconnect.ui.theme.Gray50
import org.etrange.sncfconnect.ui.theme.LightPurple
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun AccountScreen(
    innerPadding: PaddingValues, state: AccountState, onEvent: (AccountEvent) -> Unit
) {
    if (state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            CircularProgressIndicator()
        }
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.my_account),
            modifier = Modifier.padding(0.dp, 32.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 48.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(42.dp))
                    .size(84.dp)
                    .background(LightPurple)
            ) {
                Text(
                    text = state.initials,
                    fontSize = 28.sp,
                    color = DarkBlue,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = state.fullName, style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 0.2.sp
                )
            )
            Text(
                text = stringResource(R.string.manage_your_account),
                modifier = Modifier.clickable(onClick = { println("manage your account") }),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.tertiary, letterSpacing = 0.2.sp
                )
            )
        }
        Text(
            text = stringResource(R.string.discount_and_loyalty_cards),
            style = MaterialTheme.typography.titleSmall
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.purchases),
                style = MaterialTheme.typography.titleSmall
            )
            MuchMoreThanATrain()
        }

        Text(
            text = stringResource(R.string.travel_preferences),
            style = MaterialTheme.typography.titleSmall
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {}

        Text(
            text = stringResource(R.string.appendices_section),
            style = MaterialTheme.typography.titleSmall
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {}

        Text(
            text = stringResource(R.string.help), style = MaterialTheme.typography.titleSmall
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            IllustratedCard(
                icon = Icons.Default.Info,
                title = "Emergency number - 3117",
                subtitle = "Is your safety or that of others at risk?"
            )

            IllustratedCard(
                icon = Icons.Default.Info,
                title = "Care for a guided tour",
                subtitle = "Is your safety or that of others at risk?"
            )

            OutsideLink(title = "Compensation in case of delay", link = "")
            OutsideLink(title = "Delay notice", link = "")
        }

        Text(
            text = stringResource(R.string.settings), style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = stringResource(R.string.accessibility),
            style = MaterialTheme.typography.titleSmall
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.width(250.dp)) {
                    Text(
                        text = "Announcements on board",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Receive notifications whenever the train conductor makes an announcement during your trip (TGV INOUI, OUIGO, INTERCITÉS and TER)",
                        style = MaterialTheme.typography.labelMedium,
                        color = Gray50
                    )
                }
                Switch(
                    checked = state.isAnnouncementEnabled, onCheckedChange = {
                        state.isAnnouncementEnabled = !state.isAnnouncementEnabled
                    })
            }

            OutsideLink(title = "Passengers with reduced mobility", link = "")
            OutsideLink(title = "Assistance at the station (Assist'enGare)", link = "")
            OutsideLink(title = "Assistance services in Europe", link = "")
            OutsideLink(title = "Accessibility statement", link = "")

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Button(
                    onClick = { println("logout") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = "Log out", color = MaterialTheme.colorScheme.primary
                    )
                }

                Text(
                    text = "Delete your account",
                    modifier = Modifier.clickable(onClick = { println("delete your account") }),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.tertiary, letterSpacing = 0.2.sp
                    )
                )
            }
        }

        NeedHelpView()
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    SNCFConnectTheme {
        AccountScreen(
            innerPadding = PaddingValues(0.dp), state = AccountState(
                account = Account(
                    id = 1, firstName = "John", lastName = "Doe", email = ""
                )
            ), onEvent = {})
    }
}
