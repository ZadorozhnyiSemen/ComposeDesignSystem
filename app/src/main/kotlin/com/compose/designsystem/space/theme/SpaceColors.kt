package com.compose.designsystem.space.theme

import androidx.compose.material.lightColors
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf

@Stable
class SpaceColors(

) {

}

fun lightSpaceColors(

): SpaceColors = SpaceColors()

internal val LocalColors = staticCompositionLocalOf { lightSpaceColors() }