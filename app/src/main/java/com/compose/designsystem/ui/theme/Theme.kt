package com.compose.designsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.compose.designsystem.space.theme.*

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

    SpaceTheme(
        colors = colors,
        typography = SpaceTypography(),
        shapes = SpaceShapes(),
        content = content
    )
}