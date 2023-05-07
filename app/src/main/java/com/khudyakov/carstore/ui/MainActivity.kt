package com.khudyakov.carstore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.khudyakov.carstore.ui.add.AddScreen
import com.khudyakov.carstore.ui.info.InfoScreen
import com.khudyakov.carstore.ui.list.ListScreen
import com.khudyakov.carstore.ui.settings.SettingsScreen
import com.khudyakov.carstore.ui.theme.CarStoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarStoreTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ListScreen(
                viewModel = hiltViewModel(),
                onAddClick = { navController.navigate("add") },
                onItemClick = { carId -> navController.navigate("info/$carId") }
            )
        }
        composable("add") {
            AddScreen(
                viewModel = hiltViewModel(),
                onBack = { navController.navigateUp() }
            )
        }
        composable(
            "info/{carId}",
            arguments = listOf(navArgument("carId") { type = NavType.LongType } )
        ) {
            InfoScreen(
                viewModel = hiltViewModel(),
                onBack = { navController.navigateUp() }
            )
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
