package com.compose.designsystem.space.atoms

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.space.theme.LocalContentColor
import com.compose.designsystem.space.theme.SpaceTheme
import kotlin.math.max

@Composable
fun RowScope.NavTab(
    text: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val contentColor = if (selected) {
        SpaceTheme.colors.primary_4
    } else {
        SpaceTheme.colors.neutral_6
    }

    val style = if (selected) {
        SpaceTheme.typography.h4
    } else {
        SpaceTheme.typography.h4.copy(
            fontWeight = FontWeight.Normal,
        )
    }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Box(
            modifier = modifier
                .selectable(
                    selected = selected,
                    onClick = onClick,
                    enabled = true,
                    role = Role.Tab,
                    interactionSource = interactionSource,
                    indication = null,
                )
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Layout(
                {
                    Box(Modifier.layoutId("icon")) { icon() }
                    Box(Modifier.layoutId("text")) {
                        Text(
                            text = text,
                            style = style,
                        )
                    }
                }
            ) { measurables, constraints ->
                val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)
                val textPlaceable = measurables.first { it.layoutId == "text" }.measure(
                    constraints.copy(minHeight = 0)
                )

                val height = constraints.maxHeight
                val containerWidth = max(textPlaceable.width, iconPlaceable.width)

                val baseline = textPlaceable[LastBaseline]
                val baselineOffset = 10.dp.roundToPx()

                val textY = height - baseline - baselineOffset

                val iconY = baselineOffset

                val iconX = (containerWidth - iconPlaceable.width) / 2

                val textX = (containerWidth - textPlaceable.width) / 2

                layout(containerWidth, height) {
                    textPlaceable.placeRelative(textX, textY)
                    iconPlaceable.placeRelative(iconX, iconY)
                }
            }
        }
    }
}