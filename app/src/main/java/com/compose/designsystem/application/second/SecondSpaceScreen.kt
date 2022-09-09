package com.compose.designsystem.application.second

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.designsystem.R
import com.compose.designsystem.space.atoms.Button
import com.compose.designsystem.space.atoms.ButtonType
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.space.organisms.BottomSheetScreen
import com.compose.designsystem.space.organisms.Drawer
import com.compose.designsystem.space.theme.IcHeart
import com.compose.designsystem.space.theme.SpaceIcons
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun SecondSpaceScreen() {

    BottomSheetScreen(
        sheetContent = { SecondScreenBottomSheet() },
        sheetShape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp),
        sheetElevation = 16.dp,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFCCCCF2))) {
            Image(
                painter = painterResource(id = R.drawable.space),
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopCenter).padding(top = 90.dp).size(240.dp)
            )
        }
    }
}

@Composable
private fun SecondScreenBottomSheet() {
    Drawer(
        title = {
            Row {
                Text("Title", style = SpaceTheme.typography.h3)
                Spacer(modifier = Modifier.weight(1f))
                SpaceIcons.IcHeart(
                    modifier = Modifier.size(32.dp),
                    contentDescription = null,
                    tint = SpaceTheme.colors.error_4
                )
            }

        },
        description = {
            Text(
                text = "Illustration by Andy Dao. Thank you for creating these beautiful illustrations. I’ve included several in this system. Credit for the illustrations goes to Andy.",
                style = SpaceTheme.typography.h4.copy(
                    fontWeight = FontWeight.Normal,
                    color = SpaceTheme.colors.neutral_7,
                ),
                textAlign = TextAlign.Left,
            )
        },
        labels = {
            Button(onClick = {}, type = ButtonType.Secondary, shape = SpaceTheme.shapes.large) {
                Text("Illustrations", style = SpaceTheme.typography.h4.copy(fontWeight = FontWeight.Normal))
            }
            Button(onClick = {}, type = ButtonType.Secondary, shape = SpaceTheme.shapes.large) {
                Text("Cats", style = SpaceTheme.typography.h4.copy(fontWeight = FontWeight.Normal))
            }
        },
        actionButton = {
            Button(onClick = {}, shape = SpaceTheme.shapes.large) {
                Text(text = "Download", style = SpaceTheme.typography.h3, modifier = Modifier.fillMaxWidth())
            }
        }
    )
}