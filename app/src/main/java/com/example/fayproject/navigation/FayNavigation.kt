package com.example.fayproject.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fayproject.ui.appointments.AppointmentsScreen
import com.example.fayproject.ui.chat.ChatScreen
import com.example.fayproject.ui.journal.JournalScreen
import com.example.fayproject.ui.login.LoginScreen
import com.example.fayproject.ui.profile.ProfileScreen
import com.example.fayproject.ui.splashscreen.SplashScreen

@Composable
fun FayNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            val currentRoute = navBackStackEntry?.destination
            if (
                !currentRoute.isRouteInHierarchy(SplashScreenRoute::class) &&
                !currentRoute.isRouteInHierarchy(LoginScreenRoute::class)
            ) {
                BottomNavigationBar(
                    modifier = Modifier.navigationBarsPadding(),
                    navController = navController
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SplashScreenRoute,
            modifier = Modifier
        ) {
            composable<SplashScreenRoute> {
                SplashScreen(
                    navController = navController
                )
            }
            composable<LoginScreenRoute>(
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }
            ) {
                LoginScreen(
                    navController = navController
                )
            }
            composable<AppointmentsRoute> {
                AppointmentsScreen(innerPadding)
            }
            composable<ChatRoute> {
                ChatScreen()
            }
            composable<JournalRoute> {
                JournalScreen()
            }
            composable<ProfileRoute> {
                ProfileScreen()
            }
        }
    }
}
