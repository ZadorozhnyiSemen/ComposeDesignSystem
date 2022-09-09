package com.compose.designsystem.space.atoms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Divider
import com.compose.designsystem.space.atoms.basic.ProvideTextStyle
import com.compose.designsystem.space.atoms.basic.Surface
import com.compose.designsystem.space.theme.SpaceTheme

sealed interface LinkType {
    object Primary : LinkType
    object Secondary : LinkType
    object Danger : LinkType
}

@Composable
fun Link(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    drawUnderline: Boolean = true,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: LinkType = LinkType.Primary,
    content: @Composable RowScope.() -> Unit,
) {
    val color = when(type) {
        LinkType.Primary -> SpaceTheme.colors.primary_4
        LinkType.Secondary -> SpaceTheme.colors.neutral_2
        LinkType.Danger -> SpaceTheme.colors.error_2
    }

    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RectangleShape,
        contentColor = color
    ) {
        ProvideTextStyle(value = SpaceTheme.typography.h4) {
            Column(
                modifier = Modifier.width(IntrinsicSize.Max)
            ) {
                Row(
                    modifier = Modifier.padding(
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
                if (drawUnderline) {
                    Divider()
                }
            }
        }
    }
}