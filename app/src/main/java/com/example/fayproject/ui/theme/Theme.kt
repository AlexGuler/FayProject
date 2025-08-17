package com.example.fayproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = FayBlue,
    secondary = White,
    inversePrimary = White,
    onPrimary = LightFayBlueLighter,
    tertiary = LightGray,
    background = Black23,
    onBackground = AlmostBlack,
    error = Color.Red,
    surfaceDim = Black99,
    surfaceTint = BlackBlue,
    scrim = DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = FayBlue,
    secondary = AlmostBlack,
    inversePrimary = White,
    onPrimary = LightFayBlue,
    tertiary = Gray,
    background = White,
    onBackground = White,
    error = ErrorRed,
    surfaceDim = White99,
    surfaceTint = WhiteBlue,
    surfaceVariant = WhiteBluePast,
    scrim = LightGray
)

@Composable
fun FayProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
