package com.compose.designsystem.space.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.space.atoms.basic.surface
import com.compose.designsystem.space.theme.SpaceTheme

sealed interface AvatarStatus {
    object None : AvatarStatus
    object Online : AvatarStatus
    object Absent : AvatarStatus
    object Busy : AvatarStatus
}

@Composable
fun Avatar(
    painter: Painter,
    status: AvatarStatus,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
) {
    Box(
        modifier = modifier
            .size(size)
    ) {
        Image(
            modifier = Modifier
                .clip(shape)
                .fillMaxSize(),
            painter = painter,
            contentDescription = null
        )
        if (status != AvatarStatus.None) {
            Indicator(
                avatarStatus = status,
                size = size / 3,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }

}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    status: AvatarStatus,
    name: String? = null,
    shape: Shape = CircleShape,
    size: Dp = 40.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .surface(shape, SpaceTheme.colors.neutral_9),
    ) {
        if (name != null) {
            Text(
                text = name.take(1),
                style = SpaceTheme.typography.h4.copy(
                    fontWeight = FontWeight.Normal,
                    color = SpaceTheme.colors.shadesWhite,
                )
            )
        }
        if (status != AvatarStatus.None) {
            Indicator(
                avatarStatus = status,
                size = size / 4,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
private fun Indicator(
    avatarStatus: AvatarStatus,
    size: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
) {
    val color = when (avatarStatus) {
        AvatarStatus.Online -> SpaceTheme.colors.success_4
        AvatarStatus.Absent -> SpaceTheme.colors.error_4
        AvatarStatus.Busy -> SpaceTheme.colors.warning_4
        else -> Color.Unspecified
    }

    Box(
        modifier = modifier
            .background(color, shape)
            .size(size)
            .border(
                width = 2.dp,
                color = SpaceTheme.colors.shadesWhite,
                shape = shape
            )
    )
}