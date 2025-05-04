package org.etrange.sncfconnect.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.screens.catalogue.RegionalDealsCard
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun RegionalDealsSection() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.regional_deals),
                modifier = Modifier.width(200.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "See all >", color = MaterialTheme.colorScheme.primary
            )
        }

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                RegionalDealsCard(image = "", title = "Auvergne-Rhône-Alpes - TER")
                RegionalDealsCard(image = "", title = "Nouvelle-Aquitaine - TER")
            }
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                RegionalDealsCard(image = "", title = "Bourgogne-France-Comté - TER")
                RegionalDealsCard(image = "", title = "Occitanie - lio Train")
            }
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                RegionalDealsCard(image = "", title = "Centre-Val de Loire - Rémi TER")
                RegionalDealsCard(image = "", title = "Paris and its region")
            }
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                RegionalDealsCard(image = "", title = "Grand Est - TER Fluo")
                RegionalDealsCard(image = "", title = "Pays de la Loire - TER Aléop")
            }
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                RegionalDealsCard(image = "", title = "Hauts-de-France - TER")
                RegionalDealsCard(image = "", title = "SOUTH Provence-Alpes Côte d'Azur - TER")
            }
            Column {
                RegionalDealsCard(image = "", title = "Normandy - NOMAD Train")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegionalDealsSectionPreview() {
    SNCFConnectTheme {
        RegionalDealsSection()
    }
}
