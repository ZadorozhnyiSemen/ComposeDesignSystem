package com.compose.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.designsystem.application.fifth.FifthSpaceScreen
import com.compose.designsystem.application.first.FirstSpaceScreen
import com.compose.designsystem.application.forth.ForthSpaceScreen
import com.compose.designsystem.application.second.SecondSpaceScreen
import com.compose.designsystem.application.third.ThirdSpaceScreen
import com.compose.designsystem.space.atoms.Button
import com.compose.designsystem.space.atoms.basic.Text
import com.compose.designsystem.ui.theme.ComposeDesignSystemTheme

object Directions {
    const val Main = "main"
    const val FirstScreen = "first_screen"
    const val SecondScreen = "second_screen"
    const val ThirdScreen = "third_screen"
    const val ForthScreen = "forth_screen"
    const val FifthScreen = "fifth_screen"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDesignSystemTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Directions.Main) {
                    composable(Directions.Main) { MainScreen(navController = navController) }
                    composable(Directions.FirstScreen) { FirstSpaceScreen() }
                    composable(Directions.SecondScreen) { SecondSpaceScreen() }
                    composable(Directions.ThirdScreen) { ThirdSpaceScreen() }
                    composable(Directions.ForthScreen) { ForthSpaceScreen() }
                    composable(Directions.FifthScreen) { FifthSpaceScreen() }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavController
) {
    Column {
        Button(onClick = { navController.navigate(Directions.FirstScreen) }) {
            Text("History screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate(Directions.SecondScreen) }) {
            Text("Drawer screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate(Directions.ThirdScreen) }) {
            Text("Prompt screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate(Directions.ForthScreen) }) {
            Text("Checkout screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate(Directions.FifthScreen) }) {
            Text("Profiles screen")
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