package org.etrange.sncfconnect.screens.tickets.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.ui.theme.Avenir
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun PastTripsContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "stringResource(R.string.no_past_trips)",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "stringResource(R.string.past_trips_description)",
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
            imageVector = Icons.Default.DateRange,
            contentDescription = "stringResource(R.string.history_icon)",
            modifier = Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PastTripsContentPreview() {
    SNCFConnectTheme {
        PastTripsContent()
    }
}
