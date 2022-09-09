package com.compose.designsystem.space.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.basic.Divider
import com.compose.designsystem.space.atoms.basic.Surface
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun Drawer(
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
    labels: @Composable RowScope.() -> Unit,
    actionButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = SpaceTheme.colors.shadesWhite,
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 32.dp,
                top = 8.dp,
            ),
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier
                        .width(120.dp)
                        .align(Alignment.Center),
                    color = SpaceTheme.colors.neutral_2,
                    thickness = 4.dp,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            title()
            Spacer(modifier = Modifier.height(8.dp))
            description()
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                labels()
            }
            Spacer(modifier = Modifier.height(16.dp))
            actionButton()
        }
    }
}