package com.compose.designsystem.space.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun Prompt(
    title: String,
    primaryButton: @Composable () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    secondaryButton: @Composable (() -> Unit)? = null
) {

    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Column(
            modifier = modifier
                .background(
                    color = SpaceTheme.colors.neutral_2,
                    shape = SpaceTheme.shapes.medium,
                )
                .border(
                    width = 1.dp,
                    color = SpaceTheme.colors.neutral_2,
                    shape = SpaceTheme.shapes.medium,
                )
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp,
                ),
        ) {
            Text(text = title, style = SpaceTheme.typography.h3)
            description?.let {
                Text(
                    text = description, style = SpaceTheme.typography.h4.copy(
                        fontWeight = FontWeight.Normal,
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                secondaryButton?.let {
                    secondaryButton()
                    Spacer(modifier = Modifier.width(16.dp))
                }

                primaryButton()
            }
        }
    }
}