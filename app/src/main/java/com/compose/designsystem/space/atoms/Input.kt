package com.compose.designsystem.space.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.theme.LocalContentColor
import com.compose.designsystem.space.theme.SpaceTheme

sealed interface InputType {
    object Default : InputType
    object Success : InputType
    object Error : InputType
}

private val MinHeight = 40.dp
private val MinWidth = 77.dp

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = SpaceTheme.typography.h4.copy(fontWeight = FontWeight.Normal),
    inputType: InputType = InputType.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    val textColor = textStyle.color

    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    val cursorColor = when (inputType) {
        InputType.Default -> SpaceTheme.colors.shadesBlack
        InputType.Error -> SpaceTheme.colors.error_4
        InputType.Success -> SpaceTheme.colors.success_4
    }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(
                color = SpaceTheme.colors.neutral_1,
                shape = SpaceTheme.shapes.small,
            )
            .defaultMinSize(
                minWidth = MinWidth,
                minHeight = MinHeight,
            ),
        enabled = enabled,
        textStyle = mergedTextStyle,
        cursorBrush = SolidColor(cursorColor),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        maxLines = 1,
        decorationBox = @Composable { innerTextField ->
            InputDecoration(
                value = value,
                inputType = inputType,
                innerTextField = innerTextField,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                singleLine = false,
                interactionSource = interactionSource,
            )
        }

    )
}

@Composable
private fun InputDecoration(
    value: String,
    inputType: InputType,
    interactionSource: MutableInteractionSource,
    innerTextField: @Composable () -> Unit,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    singleLine: Boolean = false,
) {
    val borderSize = when (inputType) {
        InputType.Default -> 1.dp
        InputType.Error -> 2.dp
        InputType.Success -> 2.dp
    }

    val iconColor = when (inputType) {
        InputType.Default -> SpaceTheme.colors.shadesBlack
        InputType.Error -> SpaceTheme.colors.error_4
        InputType.Success -> SpaceTheme.colors.success_4
    }

    val borderColor = when (inputType) {
        InputType.Default -> SpaceTheme.colors.neutral_3
        InputType.Error -> SpaceTheme.colors.error_4
        InputType.Success -> SpaceTheme.colors.success_4
    }

    Box(
        modifier = Modifier.border(
            border = BorderStroke(borderSize, borderColor),
            shape = SpaceTheme.shapes.small
        )
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            leadingIcon?.let {
                leadingIcon()
                Spacer(modifier = Modifier.width(8.dp))
            }
            innerTextField()
            trailingIcon?.let {
                Spacer(modifier = Modifier.width(8.dp))
                CompositionLocalProvider(
                    LocalContentColor provides iconColor
                ) {
                    trailingIcon()
                }
            }
        }
    }
}