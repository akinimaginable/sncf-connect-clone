package org.etrange.sncfconnect.screens.catalogue

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.components.CatalogueCard
import org.etrange.sncfconnect.ui.components.NeedHelpView
import org.etrange.sncfconnect.ui.components.RegionalDealsSection
import org.etrange.sncfconnect.ui.theme.Gray50
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun CatalogueScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.search_the_offers),
            modifier = Modifier.padding(top = 32.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp),
            placeholder = { Text(text = stringResource(R.string.card_season_ticket)) },
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedPlaceholderColor = Gray50
            )
        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.sncf_cards_and_season_tickets),
                    modifier = Modifier.width(200.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "See all >", color = MaterialTheme.colorScheme.primary
                )
            }
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .height(200.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CatalogueCard(
                    title = "Carte Avantage Jeune TGV INOUI",
                    subTitle = "12 - 27 years old",
                    price = 49
                )
                CatalogueCard(
                    title = "Carte Avantage Adulte TGV INOUI",
                    subTitle = "27 - 59 years old",
                    price = 49
                )
                CatalogueCard(
                    title = "Carte Avantage Senior TGV INOUI",
                    subTitle = "60+ years old",
                    price = 49
                )
                CatalogueCard(
                    title = "Carte Liberté", subTitle = "€299 with the Pro Contract", price = 349
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Compare cards", color = MaterialTheme.colorScheme.primary
                )
            }

            RegionalDealsSection()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.our_services),
                    modifier = Modifier.width(200.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "See all >", color = MaterialTheme.colorScheme.primary
                )
            }
            NeedHelpView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogueScreenPreview() {
    SNCFConnectTheme {
        CatalogueScreen(innerPadding = PaddingValues(0.dp))
    }
}
