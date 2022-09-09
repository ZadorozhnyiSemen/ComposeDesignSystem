package com.compose.designsystem.space.atoms.basic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.theme.LocalContentAlpha
import com.compose.designsystem.space.theme.LocalContentColor

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    val colorFilter = if (tint == Color.Unspecified) {
        ColorFilter.tint(LocalContentColor.current)
    } else {
        ColorFilter.tint(tint)
    }
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }

    Box(
        modifier
            .toolingGraphicsLayer()
            .defaultSizeFor(painter)
            .paint(
                painter,
                colorFilter = colorFilter,
                contentScale = ContentScale.Fit
            )
            .then(semantics)
    )
}

private fun Modifier.defaultSizeFor(painter: Painter) =
    this.then(
        if (painter.intrinsicSize == Size.Unspecified || painter.intrinsicSize.isInfinite()) {
            Modifier.size(24.dp)
        } else {
            Modifier
        }
    )

private fun Size.isInfinite() = width.isInfinite() && height.isInfinite()