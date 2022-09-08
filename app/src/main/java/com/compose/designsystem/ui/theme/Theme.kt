package com.compose.designsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.compose.designsystem.space.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkSpaceColors()

private val LightColorPalette = lightSpaceColors()

@Composable
fun ComposeDesignSystemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = SpaceTheme.colors.shadesBlack,
    )
    systemUiController.setNavigationBarColor(
        color = SpaceTheme.colors.neutral_1
    )

    SpaceTheme(
        colors = colors,
        typography = SpaceTypography(),
        shapes = SpaceShapes(),
        content = content
    )
}