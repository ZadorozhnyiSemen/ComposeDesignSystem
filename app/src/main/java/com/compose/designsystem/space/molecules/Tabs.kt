package com.compose.designsystem.space.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Surface
import com.compose.designsystem.space.theme.SpaceTheme
import com.compose.designsystem.space.theme.contentColorFor

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    backgroundColor: Color = SpaceTheme.colors.shadesWhite,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = content,
        )
    }
}