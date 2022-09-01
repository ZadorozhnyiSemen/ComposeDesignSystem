package com.compose.designsystem.space.atoms

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = SpaceTheme.typography.h1
    )
}