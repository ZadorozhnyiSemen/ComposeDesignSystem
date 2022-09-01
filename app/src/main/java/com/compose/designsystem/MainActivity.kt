package com.compose.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.ui.theme.ComposeDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDesignSystemTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Greeting("Android")
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