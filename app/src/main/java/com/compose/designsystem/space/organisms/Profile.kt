package com.compose.designsystem.space.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.Avatar
import com.compose.designsystem.space.atoms.AvatarStatus
import com.compose.designsystem.space.atoms.Button
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.space.theme.IcCheck
import com.compose.designsystem.space.theme.SpaceIcons
import com.compose.designsystem.space.theme.SpaceTheme

data class Profile(
    val name: String,
    val image: Int,
    val position: String,
    val subscribed: Boolean,
)

@Composable
fun Profile(
    profile: Profile,
    modifier: Modifier = Modifier,
    shape: Shape = SpaceTheme.shapes.medium,
) {
    Column(
        modifier = modifier
            .background(SpaceTheme.colors.neutral_1, shape = shape)
            .padding(32.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Avatar(
            size = 80.dp,
            status = AvatarStatus.Online,
            painter = painterResource(id = profile.image)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = profile.name,
            style = SpaceTheme.typography.h2,
        )
        Text(
            text = profile.position,
            style = SpaceTheme.typography.h4.copy(
                fontWeight = FontWeight.Normal,
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {},
            shape = SpaceTheme.shapes.large,
            iconRight = if (profile.subscribed) {
                {SpaceIcons.IcCheck(contentDescription = null)}
            } else null) {
            Text(text = if (profile.subscribed) "Subscribed" else "Subscribe")
        }
    }
}