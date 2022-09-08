package com.compose.designsystem.space.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.Surface
import com.compose.designsystem.space.theme.SpaceTheme
import com.compose.designsystem.space.theme.contentColorFor

private val NavBarHeight = 64.dp

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = SpaceTheme.colors.neutral_1,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    borderColor: Color = SpaceTheme.colors.neutral_3,
    content: @Composable RowScope.() -> Unit,
) {

    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(NavBarHeight)
                .selectableGroup()
                .drawWithCache {
                    val strokeWidthPx = 1.dp.toPx()

                    onDrawWithContent {
                        drawContent()
                        drawLine(
                            borderColor,
                            Offset(0f, 0f),
                            Offset(this.size.width, 0f),
                            strokeWidth = strokeWidthPx,
                        )
                    }
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}