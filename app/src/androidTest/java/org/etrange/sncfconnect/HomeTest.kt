package org.etrange.sncfconnect

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import org.etrange.sncfconnect.screens.home.HomeScreen
import org.junit.Rule
import org.junit.Test

class HomeTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun loadHomeScreen() {
        rule.setContent { HomeScreen(innerPadding = PaddingValues(0.dp)) }

        rule.onNodeWithText("Hello 👋").assertExists()
    }
}
