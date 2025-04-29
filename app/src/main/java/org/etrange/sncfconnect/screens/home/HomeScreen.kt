package org.etrange.sncfconnect.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.components.SubComp
import org.etrange.sncfconnect.ui.theme.Accent
import org.etrange.sncfconnect.ui.theme.DarkPink
import org.etrange.sncfconnect.ui.theme.DarkPurple
import org.etrange.sncfconnect.ui.theme.DarkYellow
import org.etrange.sncfconnect.ui.theme.Gray10
import org.etrange.sncfconnect.ui.theme.Gray50
import org.etrange.sncfconnect.ui.theme.Gray60
import org.etrange.sncfconnect.ui.theme.LightPink
import org.etrange.sncfconnect.ui.theme.LightPurple
import org.etrange.sncfconnect.ui.theme.LightYellow
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

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
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(16.dp, innerPadding.calculateTopPadding(), 16.dp, 18.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.Transparent)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(0.dp, 0.dp, 42.dp, 42.dp)),
                    contentDescription = null,
                    colorFilter = null,
                    imageVector = Icons.Default.Star,
                    alpha = 0.3f
                )
            }
            Text(
                modifier = Modifier.padding(0.dp, 4.dp),
                color = Gray10,
                text = stringResource(R.string.hello),
                style = TextStyle(
                    fontSize = 16.sp, letterSpacing = 0.2.sp
                )
            )
            Text(
                color = Gray10,
                text = stringResource(R.string.search_for_your_journeys_commuter_trips_and_much_more),
                modifier = Modifier.padding(0.dp, 12.dp),
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.2.sp,
                    lineHeight = 32.sp
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
                shape = MaterialTheme.shapes.extraLarge,
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
                style = TextStyle(
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.2.sp,
                )
            )
            SubComp(
                title = stringResource(R.string.station_timetables),
                subtitle = stringResource(R.string.departures_and_arrivals_boards),
                iconVector = Icons.Default.Home,
                iconBackground = DarkPurple,
                iconTint = LightPurple
            )
            SubComp(
                title = stringResource(R.string.your_routes),
                subtitle = stringResource(R.string.routes_freq),
                iconVector = Icons.Default.Build,
                iconBackground = DarkYellow,
                iconTint = LightYellow
            )
            SubComp(
                title = stringResource(R.string.traffic_networks),
                subtitle = stringResource(R.string.disruptions_track_works_plans),
                iconVector = Icons.Default.Build,
                iconBackground = DarkPink,
                iconTint = LightPink
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(28.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = stringResource(R.string.much_more_than_a_train),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 0.2.sp,
                            )
                        )
                        Text(
                            color = Gray50,
                            text = stringResource(R.string.hire_car_hotels_etc),
                            style = TextStyle(
                                fontSize = 15.sp,
                                letterSpacing = 0.2.sp,
                            )
                        )
                    }
                    Image(
                        colorFilter = ColorFilter.tint(Accent),
                        contentDescription = null,
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight
                    )
                }
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text(
                            text = stringResource(R.string.legal_information), style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 0.2.sp,
                            )
                        )
                        Text(
                            color = Gray50,
                            text = stringResource(R.string.terms),
                            style = TextStyle(
                                fontSize = 15.sp,
                                letterSpacing = 0.2.sp,
                            )
                        )
                    }
                    Image(
                        colorFilter = ColorFilter.tint(Accent),
                        contentDescription = null,
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight
                    )
                }
            }
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
