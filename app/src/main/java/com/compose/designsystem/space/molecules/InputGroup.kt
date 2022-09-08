package com.compose.designsystem.space.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.Input
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.space.theme.SpaceShapes
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun InputGroup(
    label: String,
    onInputChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = SpaceTheme.shapes.large,
    input: String = "",
    sublabel: String? = null,
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = SpaceTheme.typography.h4.copy(fontWeight = FontWeight.Normal)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Input(
            modifier = Modifier.fillMaxWidth(),
            value = input,
            onValueChange = onInputChange,
            shape = shape,
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (sublabel != null) {
            Text(
                text = sublabel,
                style = SpaceTheme.typography.h5.copy(
                    fontWeight = FontWeight.Normal,
                    color = SpaceTheme.colors.neutral_7,
                )
            )
        } else {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}