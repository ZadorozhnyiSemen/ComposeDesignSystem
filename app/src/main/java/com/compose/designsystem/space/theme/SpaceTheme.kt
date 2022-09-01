package com.compose.designsystem.space.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun SpaceTheme(
    colors: SpaceColors = SpaceTheme.colors,
    typography: SpaceTypography = SpaceTheme.typography,
    shapes: SpaceShapes = SpaceTheme.shapes,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes
    ) {
        content()
    }
}

object SpaceTheme {
    val colors: SpaceColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: SpaceTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: SpaceShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}