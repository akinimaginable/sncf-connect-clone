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
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.bold.BookOpenText
import com.adamglin.phosphoricons.bold.House
import com.adamglin.phosphoricons.bold.QrCode
import com.adamglin.phosphoricons.bold.User
import org.etrange.sncfconnect.ui.theme.Accent
import org.etrange.sncfconnect.ui.theme.DarkBlue
import org.etrange.sncfconnect.ui.theme.Gray60

sealed class AppScreen(val route: String, val icon: ImageVector) {
    data object Home : AppScreen("Home", PhosphorIcons.Bold.House)
    data object Tickets : AppScreen("Tickets", PhosphorIcons.Bold.QrCode)
    data object Catalogue : AppScreen("Catalogue", PhosphorIcons.Bold.BookOpenText)
    data object Account : AppScreen("Account", PhosphorIcons.Bold.User)
}

@Composable
fun Navbar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute: String? = navBackStackEntry?.destination?.route
    val routes: List<AppScreen> =
        listOf(AppScreen.Home, AppScreen.Tickets, AppScreen.Catalogue, AppScreen.Account)
    val selectedIndex = routes.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)

    NavigationBar(containerColor = DarkBlue) {
        routes.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(text = screen.route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Accent,
                    selectedTextColor = Accent,
                    unselectedIconColor = Gray60,
                    unselectedTextColor = Gray60,
                    indicatorColor = Color.Transparent
                ))
        }
    }
}
