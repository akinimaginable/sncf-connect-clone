package org.etrange.sncfconnect.screens.tickets.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.theme.Avenir

@Composable
fun NoUpcomingTrips() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.no_upcoming_trips_at_the_moment),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.ticket_already_purchased),
            modifier = Modifier.padding(30.dp, 12.dp),
            style = TextStyle(
                fontFamily = Avenir,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.3.sp,
            ),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(R.drawable.tutorial),
            contentDescription = stringResource(R.string.station_board_icon),
            modifier = Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
    }
}
