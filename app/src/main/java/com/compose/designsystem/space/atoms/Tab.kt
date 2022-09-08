package com.compose.designsystem.space.atoms

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Divider
import com.compose.designsystem.space.theme.LocalContentColor
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun RowScope.Tab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val contentColor = if (selected) {
        SpaceTheme.colors.primary_4
    } else {
        SpaceTheme.colors.neutral_9
    }

    val selectedStyle = SpaceTheme.typography.h4

    val unselectedStyle = SpaceTheme.typography.h4.copy(
        fontWeight = FontWeight.Normal
    )

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
        ) {
            Column(modifier = Modifier.width(IntrinsicSize.Min)) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = text,
                    style = if (selected) selectedStyle else unselectedStyle
                )
                if (selected) {
                    Divider()
                }
            }
        }
    }

}