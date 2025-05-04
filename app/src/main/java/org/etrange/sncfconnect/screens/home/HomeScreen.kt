package org.etrange.sncfconnect.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.components.IllustratedCard
import org.etrange.sncfconnect.ui.components.MuchMoreThanATrain
import org.etrange.sncfconnect.ui.components.NeedHelpView
import org.etrange.sncfconnect.ui.components.SubComp
import org.etrange.sncfconnect.ui.theme.Accent
import org.etrange.sncfconnect.ui.theme.Achemine
import org.etrange.sncfconnect.ui.theme.Avenir
import org.etrange.sncfconnect.ui.theme.Cyan
import org.etrange.sncfconnect.ui.theme.DarkPink
import org.etrange.sncfconnect.ui.theme.DarkPurple
import org.etrange.sncfconnect.ui.theme.DarkYellow
import org.etrange.sncfconnect.ui.theme.Gray10
import org.etrange.sncfconnect.ui.theme.Gray60
import org.etrange.sncfconnect.ui.theme.LightPink
import org.etrange.sncfconnect.ui.theme.LightPurple
import org.etrange.sncfconnect.ui.theme.LightYellow
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme
import androidx.compose.material3.MaterialTheme as MT

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = innerPadding.calculateBottomPadding())
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(0.dp, 0.dp, 42.dp, 42.dp))
                .background(MT.colorScheme.tertiary)
                .padding(16.dp, innerPadding.calculateTopPadding(), 16.dp, 18.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.fallback),
                contentDescription = "Home header illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                colorFilter = ColorFilter.tint(MT.colorScheme.primary)
            )
            Text(
                text = stringResource(R.string.hello),
                modifier = Modifier.padding(0.dp, 4.dp),
                style = TextStyle(color = Gray10, fontFamily = Avenir, fontSize = 16.sp)
            )
            Text(
                color = Gray10,
                text = stringResource(R.string.search_for_your_journeys_commuter_trips_and_much_more),
                modifier = Modifier.padding(0.dp, 12.dp),
                style = TextStyle(
                    lineHeight = 32.sp,
                    fontFamily = Achemine,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .padding(0.dp, 12.dp, 0.dp)
                    .border(2.dp, Color.White, RoundedCornerShape(64.dp))
                    .fillMaxWidth(),
                placeholder = { Text(text = stringResource(R.string.a_destination_a_question)) },
                shape = MT.shapes.extraLarge,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedPlaceholderColor = Gray60,
                    focusedPlaceholderColor = Gray60
                )
            )
        }
        Column(
            modifier = Modifier.padding(16.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                modifier = Modifier.padding(0.dp, 16.dp),
                text = stringResource(R.string.simplify),
                style = MT.typography.titleLarge
            )
            SubComp(
                title = stringResource(R.string.station_timetables),
                subtitle = stringResource(R.string.departures_and_arrivals_boards),
                iconVector = R.drawable.hp_station_board,
                iconBackground = DarkPurple,
                iconTint = LightPurple
            )
            SubComp(
                title = stringResource(R.string.your_routes),
                subtitle = stringResource(R.string.routes_freq),
                iconVector = R.drawable.hp_itinerary,
                iconBackground = DarkYellow,
                iconTint = LightYellow
            )
            SubComp(
                title = stringResource(R.string.traffic_networks),
                subtitle = stringResource(R.string.disruptions_track_works_plans),
                iconVector = R.drawable.hp_traffic_info,
                iconBackground = DarkPink,
                iconTint = LightPink
            )
            SubComp(
                title = stringResource(R.string.your_upcoming_trips),
                subtitle = stringResource(R.string.details_tickets_etc),
                iconVector = R.drawable.hp_next_journey,
                iconBackground = Cyan,
                iconTint = Accent
            )
            Spacer(modifier = Modifier.padding(4.dp))
            MuchMoreThanATrain()
            Spacer(modifier = Modifier.padding(2.dp))

            IllustratedCard(
                icon = Icons.Default.Info,
                title = stringResource(R.string.legal_information),
                subtitle = stringResource(R.string.terms)
            )

            Spacer(modifier = Modifier.padding(2.dp))

            NeedHelpView()
            Spacer(modifier = Modifier.padding(6.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SNCFConnectTheme {
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}
