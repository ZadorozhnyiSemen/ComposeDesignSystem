package com.compose.designsystem.space.atoms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.theme.SpaceTheme

sealed interface ButtonType {
    object Primary : ButtonType
    object Secondary : ButtonType
    object Danger : ButtonType
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    rounded: Boolean = false,
    type: ButtonType = ButtonType.Primary,
    content: @Composable RowScope.() -> Unit,
) {
    val color = when(type) {
        ButtonType.Primary -> SpaceTheme.colors.primary_4
        ButtonType.Secondary -> SpaceTheme.colors.neutral_2
        ButtonType.Danger -> SpaceTheme.colors.error_2
    }

    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = if (rounded) SpaceTheme.shapes.large else RectangleShape,
        color = color,
    ) {
        ProvideTextStyle(value = SpaceTheme.typography.h4) {
            Row(
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                iconLeft?.let {
                    iconLeft()
                    Spacer(modifier = Modifier.width(8.dp))
                }
                content()
                iconRight?.let {
                    Spacer(modifier = Modifier.width(8.dp))
                    iconRight()
                }
            }
        }
    }
}
