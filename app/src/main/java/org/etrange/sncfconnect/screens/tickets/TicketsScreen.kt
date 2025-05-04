package org.etrange.sncfconnect.screens.tickets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.components.IllustratedCard
import org.etrange.sncfconnect.ui.components.NeedHelpView
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TicketsScreen(innerPadding: PaddingValues) {
    var state by remember { mutableIntStateOf(0) }
    var titles = listOf<String>("Upcoming", "Past")

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
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Import +", style = TextStyle(
                        fontSize = MaterialTheme.typography.labelLarge.fontSize
                    )
                )
            }
        }

        Text(
            text = "Your cards and local passes",
            modifier = Modifier.padding(vertical = 16.dp),
            style = MaterialTheme.typography.titleSmall
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CardsAndPasses(name = "Your QR code SNCF cards")
            CardsAndPasses(name = "Paris and its region")
        }

        Text(
            text = "Your trips",
            modifier = Modifier.padding(vertical = 16.dp),
            style = MaterialTheme.typography.titleSmall
        )
        SecondaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) })
            }
        }

        IllustratedCard(
            icon = Icons.Default.Info,
            title = "Emergency number - 3117",
            subtitle = "Is your safety or that of others at risk?"
        )

        NeedHelpView()
    }
}

@Composable
private fun CardsAndPasses(name: String) {
    Column(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.qr_code),
            contentDescription = "QR code icon",
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = name, textAlign = TextAlign.Center, style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TicketsScreenPreview() {
    SNCFConnectTheme {
        TicketsScreen(PaddingValues(0.dp))
    }
}
