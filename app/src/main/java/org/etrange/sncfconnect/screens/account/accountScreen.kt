package org.etrange.sncfconnect.screens.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.ui.theme.DarkBlue

@Composable
fun AccountScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "My account", style = TextStyle(
                fontSize = 24.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.2.sp
            )
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(42.dp))
                    .size(84.dp)
                    .background(Color(0XFFE29AFD))
            ) {
                Text(
                    text = "AK",
                    fontSize = 28.sp,
                    color = DarkBlue,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = "Akinimaginable", style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.2.sp
                )
            )
        }
        Text(
            text = "Discount and loyalty cards", style = TextStyle(
                fontSize = 18.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.2.sp
            )
        )
    }
}