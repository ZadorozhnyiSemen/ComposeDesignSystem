package com.compose.designsystem.space.atoms

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.theme.LocalContentColor
import com.compose.designsystem.space.theme.SpaceTheme
import com.compose.designsystem.space.theme.contentColorFor

private val IconButtonSize = 40.dp

sealed interface IconButtonType {
    object Default : IconButtonType
    object Secondary : IconButtonType
    object Danger : IconButtonType
}

@Composable
fun IconButton(
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconButtonType: IconButtonType = IconButtonType.Default,
) {
    val backgroundColor = when (iconButtonType) {
        IconButtonType.Danger -> SpaceTheme.colors.error_2
        IconButtonType.Default -> SpaceTheme.colors.primary_4
        IconButtonType.Secondary -> SpaceTheme.colors.neutral_2
    }

    val iconColor = contentColorFor(backgroundColor = backgroundColor)

    CompositionLocalProvider(
        LocalContentColor provides iconColor
    ) {
        Layout(
            modifier = modifier.then(
                Modifier.background(backgroundColor, SpaceTheme.shapes.large)
            ),
            content = icon
        ) { measurables, constraints ->
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            val boxWidth = IconButtonSize.toPx().toInt()
            val boxHeight = IconButtonSize.toPx().toInt()

            layout(boxWidth, boxWidth) {
                placeables.forEach { placeable ->
                    val x = boxWidth / 2 - placeable.width / 2
                    val y = boxHeight / 2 - placeable.height / 2
                    placeable.placeRelative(x = x, y = y)
                }
            }
        }
    }
}