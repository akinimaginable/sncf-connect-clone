package org.etrange.sncfconnect.screens.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.models.Account
import org.etrange.sncfconnect.ui.theme.DarkBlue
import org.etrange.sncfconnect.ui.theme.SNCFConnectTheme

@Composable
fun AccountScreen(
    innerPadding: PaddingValues, state: AccountState, onEvent: (AccountEvent) -> Unit
) {
    if (state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        ) {
            CircularProgressIndicator()
        }
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.my_account), style = MaterialTheme.typography.titleLarge
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 48.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(42.dp))
                    .size(84.dp)
                    .background(Color(0XFFE29AFD))
            ) {
                Text(
                    text = state.initial,
                    fontSize = 28.sp,
                    color = DarkBlue,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = state.fullName, style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 0.2.sp
                )
            )
            Text(
                text = stringResource(R.string.manage_your_account), style = TextStyle(
                    color = MaterialTheme.colorScheme.tertiary, letterSpacing = 0.2.sp
                )
            )
        }
        Text(
            text = stringResource(R.string.discount_and_loyalty_cards),
            style = MaterialTheme.typography.titleSmall
        )

        Text(text = stringResource(R.string.purchases), style = MaterialTheme.typography.titleSmall)

        Text(
            text = stringResource(R.string.travel_preferences),
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = stringResource(R.string.appendices_section),
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = stringResource(R.string.help), style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = stringResource(R.string.settings), style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = stringResource(R.string.accessibility),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    SNCFConnectTheme {
        AccountScreen(
            innerPadding = PaddingValues(0.dp), state = AccountState(
                account = Account(
                    id = 1, firstName = "John", lastName = "Doe", email = ""
                )
            ), onEvent = {})
    }
}
