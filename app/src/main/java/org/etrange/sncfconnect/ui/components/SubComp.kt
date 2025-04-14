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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.ui.theme.Accent

@Composable
fun SubComp(
    title: String, subtitle: String, iconVector: ImageVector, iconBackground: Color, iconTint: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row {
            Image(
                colorFilter = ColorFilter.tint(iconTint),
                contentDescription = null,
                imageVector = iconVector,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(iconBackground)
                    .padding(10.dp)
                    .size(28.dp)
            )
            Column(modifier = Modifier.padding(12.dp, 0.dp)) {
                Text(
                    text = title, style = TextStyle(
                        fontSize = 18.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.1.sp,
                    )
                )
                Text(text = subtitle, fontSize = 15.sp, color = Color(0xFF9B9EA3))
            }
        }
        Image(
            colorFilter = ColorFilter.tint(Accent),
            contentDescription = null,
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            modifier = Modifier.padding(8.dp, 0.dp)
        )
    }
}
