package com.compose.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.compose.designsystem.application.fifth.FifthSpaceScreen
import com.compose.designsystem.application.first.FirstSpaceScreen
import com.compose.designsystem.application.second.SecondSpaceScreen
import com.compose.designsystem.ui.theme.ComposeDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDesignSystemTheme {
                FifthSpaceScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    ComposeDesignSystemTheme {
        FirstSpaceScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    ComposeDesignSystemTheme {
        SecondSpaceScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    ComposeDesignSystemTheme {
        FirstSpaceScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ForthScreenPreview() {
    ComposeDesignSystemTheme {
        FirstSpaceScreen()
    }
}