package org.etrange.sncfconnect.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.ui.theme.Gray50
import androidx.compose.material3.MaterialTheme as MT

@Composable
fun IllustratedCard(icon: ImageVector, title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MT.colorScheme.surface)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            colorFilter = ColorFilter.tint(MT.colorScheme.primary),
            contentDescription = null,
            imageVector = icon,
        )
        Column(modifier = Modifier.width(270.dp)) {
            Text(
                text = title, style = MT.typography.headlineMedium
            )
            Text(
                text = subtitle, style = MT.typography.labelMedium, color = Gray50
            )
        }
        Image(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "More icon",
            colorFilter = ColorFilter.tint(MT.colorScheme.primary)
        )
    }
}