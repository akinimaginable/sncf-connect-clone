package org.etrange.sncfconnect.screens.catalogue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun CatalogueScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Search the offers", style = MaterialTheme.typography.titleLarge)
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp),
            placeholder = { Text(text = "Card, season ticket") },
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )
        Column {
            Text(
                text = stringResource(R.string.sncf_cards_and_season_tickets),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(R.string.regional_deals),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(R.string.our_services),
                style = MaterialTheme.typography.titleSmall
            )
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
