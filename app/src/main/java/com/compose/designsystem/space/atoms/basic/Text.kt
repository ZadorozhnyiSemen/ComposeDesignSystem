package com.compose.designsystem.space.atoms.basic

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.compose.designsystem.space.theme.LocalContentAlpha
import com.compose.designsystem.space.theme.LocalContentColor
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    style: TextStyle = SpaceTheme.typography.h4,
    textAlign: TextAlign = TextAlign.Center
) {
    val textColor = color.takeOrElse {
        style.color.takeOrElse {
            LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        }
    }

    val mergedStyle = style.copy(color = textColor, textAlign = textAlign)

    BasicText(
        text = text,
        modifier = modifier,
        style = mergedStyle,
    )
}

@Composable
fun ProvideTextStyle(value: TextStyle, content: @Composable () -> Unit) {
    val mergedStyle = LocalTextStyle.current.merge(value)
    CompositionLocalProvider(LocalTextStyle provides mergedStyle, content = content)
}

val LocalTextStyle = compositionLocalOf(structuralEqualityPolicy()) { TextStyle.Default }