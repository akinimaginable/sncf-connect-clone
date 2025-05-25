package org.etrange.sncfconnect.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.etrange.sncfconnect.screens.account.AccountRoute
import org.etrange.sncfconnect.screens.catalogue.CatalogueScreen
import org.etrange.sncfconnect.screens.home.HomeScreen
import org.etrange.sncfconnect.screens.tickets.TicketsScreen

@Composable
fun AppNavigation(startDestination: String = "Home") {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destinations.Home.route) {
            AppScaffold(navController = navController) { innerPadding ->
                HomeScreen(innerPadding)
            }
        }
        composable(Destinations.Tickets.route) {
            AppScaffold(navController = navController) { innerPadding ->
                TicketsScreen(innerPadding)
            }
        }
        composable(Destinations.Catalogue.route) {
            AppScaffold(navController = navController) { innerPadding ->
                CatalogueScreen(innerPadding)
            }
        }
        composable(Destinations.Account.route) {
            AppScaffold(navController = navController) { innerPadding ->
                AccountRoute(innerPadding)
            }
        }
    }
}

@Composable
private fun AppScaffold(
    navController: NavHostController, content: @Composable (innerPadding: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = { Navbar(navController) }) { innerPadding ->
        content(innerPadding)
    }
}
