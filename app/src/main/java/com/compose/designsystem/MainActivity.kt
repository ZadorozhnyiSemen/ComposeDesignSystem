package com.compose.designsystem

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.designsystem.space.atoms.Button
import com.compose.designsystem.space.atoms.ButtonType
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.space.theme.IcAdd
import com.compose.designsystem.space.theme.IcApps
import com.compose.designsystem.space.theme.IcCheck
import com.compose.designsystem.space.theme.SpaceIcons
import com.compose.designsystem.ui.theme.ComposeDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDesignSystemTheme {
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