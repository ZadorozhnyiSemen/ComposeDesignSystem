package com.compose.designsystem.space.atoms.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.theme.LocalContentColor

@Composable
fun Divider(
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current,
    thickness: Dp = 2.dp,
    startIndent: Dp = 0.dp
) {
    val indentMod = if (startIndent.value != 0f) {
        Modifier.padding(start = startIndent)
    } else {
        Modifier
    }
    val targetThickness = if (thickness == Dp.Hairline) {
        (1f / LocalDensity.current.density).dp
    } else {
        thickness
    }
    Box(
        modifier.then(indentMod)
            .fillMaxWidth()
            .height(targetThickness)
            .background(color = color)
    )
}