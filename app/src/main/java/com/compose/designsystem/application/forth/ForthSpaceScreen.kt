package com.compose.designsystem.application.forth

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.Button
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.space.molecules.InputGroup
import com.compose.designsystem.space.molecules.SelectGroup
import com.compose.designsystem.space.organisms.Form
import com.compose.designsystem.space.theme.SpaceTheme

@Composable
fun ForthSpaceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 32.dp,
            )
    ) {
        Text(
            text = "Checkout",
            style = SpaceTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Form(
            inputs = {
                InputGroup(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Name on card",
                    onInputChange = {},
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputGroup(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Card Number",
                    onInputChange = {},
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    SelectGroup(
                        modifier = Modifier.weight(1f),
                        label = "Month",
                        input = "Jan",
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    SelectGroup(
                        modifier = Modifier.weight(1f),
                        label = "Year",
                        input = "2022",
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    InputGroup(
                        modifier = Modifier.weight(1f),
                        label = "CVC",
                        onInputChange = {},
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    InputGroup(
                        modifier = Modifier.weight(1f),
                        label = "Zip Code",
                        onInputChange = {},
                    )
                }
            },
            submitButton = {
                Button(
                    modifier = Modifier.height(48.dp),
                    onClick = {},
                    shape = SpaceTheme.shapes.large,
                ) {
                    Text(
                        text = "Submit",
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        )
    }
}