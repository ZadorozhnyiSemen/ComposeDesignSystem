package com.compose.designsystem.space.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Form(
    inputs: @Composable ColumnScope.() -> Unit,
    submitButton: @Composable () -> Unit,
) {
    Column {
        inputs()
        Spacer(modifier = Modifier.weight(1f))
        submitButton()
    }
}