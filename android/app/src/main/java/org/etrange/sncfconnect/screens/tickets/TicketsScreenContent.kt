package org.etrange.sncfconnect.screens.tickets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.screens.tickets.components.CardsAndPasses
import org.etrange.sncfconnect.screens.tickets.components.NoUpcomingTrips
import org.etrange.sncfconnect.screens.tickets.components.PastTripsContent
import org.etrange.sncfconnect.ui.components.IllustratedCard
import org.etrange.sncfconnect.ui.components.MuchMoreThanATrain
import org.etrange.sncfconnect.ui.components.NeedHelpView
import org.etrange.sncfconnect.ui.theme.Avenir
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TicketsScreenContent(
    innerPadding: PaddingValues, state: TicketsScreenState = TicketsScreenState(
        tabTitles = persistentListOf(
            stringResource(R.string.upcoming), stringResource(R.string.past)
        )
    ), onEvent: (TicketsScreenEvent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp, 6.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.tickets),
                modifier = Modifier.padding(0.dp, 32.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.import_label), style = TextStyle(
                            fontFamily = Avenir,
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Image(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.plus_icon),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background),
                        modifier = Modifier
                            .size(26.dp)
                            .clip(RoundedCornerShape(13.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(2.dp)
                    )
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = stringResource(R.string.your_cards_and_local_passes),
                style = MaterialTheme.typography.titleSmall
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CardsAndPasses(name = stringResource(R.string.your_qr_code_sncf_cards))
                CardsAndPasses(name = stringResource(R.string.paris_and_its_region))
            }
            Spacer(modifier = Modifier.height(0.dp))
            Text(
                text = stringResource(R.string.your_trips),
                style = MaterialTheme.typography.titleSmall
            )
            SecondaryTabRow(
                selectedTabIndex = state.selectedTab,
                containerColor = MaterialTheme.colorScheme.background
            ) {
                state.tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = state.selectedTab == index,
                        onClick = { onEvent(TicketsScreenEvent.TabSelected(index)) },
                        text = {
                            Text(
                                text = title, maxLines = 2, overflow = TextOverflow.Ellipsis
                            )
                        },
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            when (state.selectedTab) {
                0 -> NoUpcomingTrips()
                1 -> PastTripsContent()
            }

            MuchMoreThanATrain()
            IllustratedCard(
                icon = Icons.Default.Info,
                title = stringResource(R.string.emergency_number_3117),
                subtitle = stringResource(R.string.is_your_safety_or_that_of_others_at_risk)
            )
            Spacer(modifier = Modifier.height(0.dp))
            NeedHelpView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicketsScreenPreview() {
    SNCFConnectTheme {
        TicketsScreenContent(PaddingValues(0.dp))
    }
}
