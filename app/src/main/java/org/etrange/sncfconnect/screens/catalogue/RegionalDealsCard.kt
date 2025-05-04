package org.etrange.sncfconnect.screens.catalogue

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.R

@Composable
fun RegionalDealsCard(image: String, title: String) {
    Column(
        modifier = Modifier.width(200.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ter_default_image),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            modifier = Modifier.padding(0.dp, 4.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
fun RegionalDealsCardPreview() {
    RegionalDealsCard(image = "", title = "Auvergne-Rhône-Alpes - TER")
}
