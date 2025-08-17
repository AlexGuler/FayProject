package com.example.fayproject.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlin.reflect.KClass

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val lineColor = MaterialTheme.colorScheme.scrim
    BottomNavigation(
        modifier = modifier
            .drawBehind {
                // Draw a line at the top of the composable
                drawLine(
                    color = lineColor,
                    start = Offset(x = 0f, y = 0f), // Top-left corner
                    end = Offset(x = size.width, y = 0f), // Top-right corner
                    strokeWidth = 2.dp.toPx() // Convert DP to pixels for stroke width
                )
            },
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavDestination.entries.forEach { destination ->
            val selected = currentDestination.isRouteInHierarchy(destination.route)
            val color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.secondary
            }
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(destination.toRoute()) {
                        popUpTo(AppointmentsRoute) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = stringResource(destination.iconTextId),
                        tint = color,
                    )
                },
                label = {
                    Text(
                        text = stringResource(destination.iconTextId),
                        color = color,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            )
        }
    }
}

internal fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false

private fun BottomNavDestination.toRoute() =
    when (this) {
        BottomNavDestination.APPOINTMENTS -> AppointmentsRoute
        BottomNavDestination.CHAT -> ChatRoute
        BottomNavDestination.JOURNAL -> JournalRoute
        BottomNavDestination.PROFILE -> ProfileRoute
    }
