package org.etrange.sncfconnect.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NeedHelpView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.LightGray)
            .padding(24.dp)
    ) {
        Text(text = "Need help?", style = TextStyle(fontWeight = FontWeight.Medium))
        Text(text = "Let's find the answer to your question")
        Button(
            onClick = { },
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Start a conversation", color = MaterialTheme.colorScheme.tertiary)
        }
    }
}

@Preview
@Composable
fun NeedHelpViewPreview() {
    NeedHelpView()
}
