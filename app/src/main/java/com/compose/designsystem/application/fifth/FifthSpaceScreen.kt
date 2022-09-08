package com.compose.designsystem.application.fifth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.designsystem.R
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.space.organisms.Profile
import com.compose.designsystem.space.theme.SpaceTheme

private val profiles = listOf(
    Profile("John Smith", R.drawable.john, "Employee", true),
    Profile("Rose Taylor", R.drawable.rose, "Legendary Explorer", false),
)

@Composable
fun FifthSpaceScreen() {
    val profiles by remember { mutableStateOf(profiles) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 32.dp
            )
    ) {
        Text(
            text = "Profiles",
            style = SpaceTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(16.dp))
        profiles.map { profile ->
            Profile(profile)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}