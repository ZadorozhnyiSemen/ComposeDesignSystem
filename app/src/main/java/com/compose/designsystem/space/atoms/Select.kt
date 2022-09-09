package com.compose.designsystem.space.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.space.theme.IcKeyboardArrowDown
import com.compose.designsystem.space.theme.SpaceIcons
import com.compose.designsystem.space.theme.SpaceTheme

sealed interface SelectType {
    object Default : SelectType
    object Success : SelectType
    object Error : SelectType
}

private val MinHeight = 40.dp
private val MinWidth = 77.dp

@Composable
fun Select(
    text: String,
    modifier: Modifier = Modifier,
    inSelectionMode: Boolean = false,
    selectType: SelectType = SelectType.Default,
    shape: Shape = SpaceTheme.shapes.small,
    textStyle: TextStyle = SpaceTheme.typography.h4.copy(fontWeight = FontWeight.Normal),
) {

    val borderSize = when (selectType) {
        SelectType.Default -> 1.dp
        SelectType.Error -> 2.dp
        SelectType.Success -> 2.dp
    }

    val borderColor = when (selectType) {
        SelectType.Default -> SpaceTheme.colors.neutral_3
        SelectType.Error -> SpaceTheme.colors.error_4
        SelectType.Success -> SpaceTheme.colors.success_4
    }

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = MinWidth,
                minHeight = MinHeight,
            )
            .background(SpaceTheme.colors.neutral_1, shape = shape)
            .border(
                border = BorderStroke(borderSize, borderColor),
                shape = shape
            )

    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                style = textStyle,
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.width(4.dp))
            if (!inSelectionMode) {
                SpaceIcons.IcKeyboardArrowDown(contentDescription = null)
            } else {
                SpaceIcons.IcKeyboardArrowDown(
                    contentDescription = null,
                    rotate = true,
                )
            }
        }
    }
}