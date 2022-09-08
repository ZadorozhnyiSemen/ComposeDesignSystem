package com.compose.designsystem.application.third

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.compose.designsystem.space.atoms.Button
import com.compose.designsystem.space.atoms.ButtonType
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.space.organisms.Prompt
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun ThirdSpaceScreen() {

    var showPrompt by remember {
        mutableStateOf(true)
    }

    if (showPrompt) {
        Prompt(
            title = "Reset Password",
            description = "Are you sure?",
            secondaryButton = {
                Button(onClick = { showPrompt = false }, type = ButtonType.Secondary) {
                    Text("No", style = SpaceTheme.typography.h4.copy(
                        color = SpaceTheme.colors.neutral_5
                    ))
                }
            },
            primaryButton = {
                Button(onClick = { showPrompt = false }, shape = SpaceTheme.shapes.small) {
                    Text("Yes")
                }
            },
            onDismiss = { showPrompt = false },
        )
    }

    
    Box(Modifier.fillMaxSize()) {
        Button(onClick = { showPrompt = true }) {
            Text(text = "Show prompt")
        }
    }
}