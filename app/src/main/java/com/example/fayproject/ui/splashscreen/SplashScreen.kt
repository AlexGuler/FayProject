package com.example.fayproject.ui.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.fayproject.R
import com.example.fayproject.navigation.AppointmentsRoute
import com.example.fayproject.navigation.LoginScreenRoute

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val viewModel: SplashScreenViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.navigationEvents.collect {
            when (it) {
                SplashNavigationEvent.NavigateToLogin -> {
                    navController.navigate(LoginScreenRoute) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }

                SplashNavigationEvent.NavigateToMainScreen -> {
                    navController.navigate(AppointmentsRoute) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.fay_logo),
            contentDescription = stringResource(R.string.fay),
            alignment = Alignment.Center,
            colorFilter = if (isSystemInDarkTheme()) {
                ColorFilter.tint(Color.White)
            } else {
                null
            },
            modifier = Modifier
                .padding(bottom = 100.dp)
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.Center)
        )
    }
}
