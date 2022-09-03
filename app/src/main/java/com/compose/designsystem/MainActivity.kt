package com.compose.designsystem

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.*
import com.compose.designsystem.space.theme.*
import com.compose.designsystem.ui.theme.ComposeDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDesignSystemTheme {
                var text by remember {
                    mutableStateOf("Input")
                }
                // A surface container using the 'background' color from the theme
                Column {
                    Greeting("Android")
                    Button(onClick = {
                        Toast.makeText(this@MainActivity, "Pressed", Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Text")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        onClick = { },
                        type = ButtonType.Secondary,
                        iconLeft = { SpaceIcons.IcApps(contentDescription = null) },
                    ) {
                        Text("Text")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        onClick = { },
                        type = ButtonType.Danger,
                        iconRight = { SpaceIcons.IcApps(contentDescription = null) },
                    ) {
                        Text("Text")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        onClick = { },
                        rounded = true,
                        iconLeft = { SpaceIcons.IcAdd(contentDescription = null) },
                        iconRight = { SpaceIcons.IcCheck(contentDescription = null) },
                    ) {
                        Text("Hello button text")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Link(
                        onClick = {},
                        iconLeft = { SpaceIcons.IcAdd(contentDescription = null) },
                    ) {
                        Text("Link text")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        onClick = { },
                        rounded = true,
                    ) {
                        Text(
                            "Download",
                            modifier = Modifier.fillMaxWidth(),
                            style = SpaceTheme.typography.h3
                        )

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Input(
                        text,
                        {
                            text = it
                            println("nwe value $it")
                        },
                        leadingIcon = { SpaceIcons.IcCheck(contentDescription = null) },
                        trailingIcon = { SpaceIcons.IcCheck(contentDescription = null) },
                        inputType = InputType.Error,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    IconButton(
                        icon = { SpaceIcons.IcContactSupport(contentDescription = null) },
                        onClick = {},
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    IconButton(
                        icon = { SpaceIcons.IcContactSupport(contentDescription = null) },
                        onClick = {},
                        iconButtonType = IconButtonType.Secondary,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    IconButton(
                        icon = { SpaceIcons.IcAttachMoney(contentDescription = null) },
                        onClick = {},
                        iconButtonType = IconButtonType.Danger,
                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello world!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDesignSystemTheme {
        Greeting("Android")
    }
}