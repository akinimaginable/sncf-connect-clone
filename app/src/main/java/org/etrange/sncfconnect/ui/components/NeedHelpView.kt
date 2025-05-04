package org.etrange.sncfconnect.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.theme.Avenir
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

fun androidx.compose.material3.ColorScheme.isLight(): Boolean {
    // Check if background color is closer to white than black
    val luminance = background.red * 0.299 + background.green * 0.587 + background.blue * 0.114
    return luminance > 0.5
}

@Composable
fun NeedHelpView() {
    val icon: Int =
        if (!MaterialTheme.colorScheme.isLight()) R.drawable.help_emoji_dark else R.drawable.help_emoji_light

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.help_icon),
            modifier = Modifier.size(76.dp),
        )
        Text(
            text = stringResource(R.string.need_help),
            modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleSmall
        )
        Text(text = stringResource(R.string.let_s_find_the_answer_to_your_question))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(R.string.start_a_conversation),
                modifier = Modifier.padding(vertical = 4.dp),
                color = MaterialTheme.colorScheme.primary,
                style = TextStyle(
                    fontFamily = Avenir, fontSize = 16.sp, fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NeedHelpViewPreview() {
    SNCFConnectTheme {
        NeedHelpView()
    }
}
