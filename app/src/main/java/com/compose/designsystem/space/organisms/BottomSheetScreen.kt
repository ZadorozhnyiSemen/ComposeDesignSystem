package com.compose.designsystem.space.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp

@Composable
fun BottomSheetScreen(
    sheetContent: @Composable () -> Unit,
    sheetShape: Shape,
    sheetElevation: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BoxWithConstraints(modifier) {
        BottomSheetScreenStack(body = {
            Column(Modifier.fillMaxSize()) {
                content()
            }
        }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = sheetElevation, sheetShape, clip = false)
                    .clip(sheetShape)
            ) {
                sheetContent()
            }
        }
    }
}

@Composable
private fun BottomSheetScreenStack(
    body: @Composable () -> Unit,
    bottomSheet: @Composable () -> Unit,
) {
    Layout(
        content = {
            body()
            bottomSheet()
        }
    ) { measurables, constraints ->
        val placeable = measurables.first().measure(constraints)

        layout(placeable.width, placeable.height) {
            placeable.placeRelative(0, 0)

            val (sheetPlaceable) = measurables.drop(1).map {
                it.measure(constraints.copy(minWidth = 0, minHeight = 0))
            }

            sheetPlaceable.placeRelative(0, constraints.maxHeight - sheetPlaceable.height)
        }
    }
}
