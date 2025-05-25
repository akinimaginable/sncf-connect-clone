package org.etrange.sncfconnect.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.theme.DarkPurple
import org.etrange.sncfconnect.ui.theme.Gray50
import org.etrange.sncfconnect.ui.theme.LightPurple
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun SubComp(
    title: String, subtitle: String, iconVector: Int, iconBackground: Color, iconTint: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row {
            Image(
                colorFilter = ColorFilter.tint(iconTint),
                contentDescription = null,
                painter = painterResource(id = iconVector),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(iconBackground)
                    .padding(10.dp)
                    .size(32.dp)
            )
            Column(modifier = Modifier.padding(12.dp, 3.dp)) {
                Text(
                    text = title, style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = subtitle, style = MaterialTheme.typography.labelMedium, color = Gray50
                )
            }
        }
        Image(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "More",
            modifier = Modifier.padding(horizontal = 8.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
    }
}

@Preview
@Composable
fun SubCompPreview() {
    SNCFConnectTheme {
        SubComp(
            title = "Title",
            subtitle = "Subtitle",
            iconVector = R.drawable.hp_station_board,
            iconBackground = DarkPurple,
            iconTint = LightPurple
        )
    }
}
