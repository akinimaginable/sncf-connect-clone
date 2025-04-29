package org.etrange.sncfconnect.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.bold.BookOpenText
import com.adamglin.phosphoricons.bold.House
import com.adamglin.phosphoricons.bold.QrCode
import com.adamglin.phosphoricons.bold.User
import org.etrange.sncfconnect.R
import org.etrange.sncfconnect.ui.theme.Accent
import org.etrange.sncfconnect.ui.theme.DarkBlue
import org.etrange.sncfconnect.ui.theme.Gray60

interface NavigationDestination {
    val route: String
    val icon: ImageVector
    val label: Int
}

object Destinations {
    val Home = object : NavigationDestination {
        override val route = "home"
        override val icon = PhosphorIcons.Bold.House
        override val label = R.string.home
    }

    val Tickets = object : NavigationDestination {
        override val route = "tickets"
        override val icon = PhosphorIcons.Bold.QrCode
        override val label = R.string.tickets
    }

    val Catalogue = object : NavigationDestination {
        override val route = "catalogue"
        override val icon = PhosphorIcons.Bold.BookOpenText
        override val label = R.string.catalogue
    }

    val Account = object : NavigationDestination {
        override val route = "account"
        override val icon = PhosphorIcons.Bold.User
        override val label = R.string.account
    }

    val bottomNavDestinations = listOf(Home, Tickets, Catalogue, Account)
}

@Composable
fun Navbar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomNavItems = Destinations.bottomNavDestinations

    NavigationBar(containerColor = DarkBlue) {
        bottomNavItems.forEach { destination ->
            val selected = currentRoute == destination.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(Destinations.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = "${destination.label} icon") },
                label = { Text(text = stringResource(destination.label)) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Accent,
                    selectedTextColor = Accent,
                    unselectedIconColor = Gray60,
                    unselectedTextColor = Gray60,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
