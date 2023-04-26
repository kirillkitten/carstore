package com.khudyakov.carstore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khudyakov.carstore.ui.item.ItemScreen
import com.khudyakov.carstore.ui.list.ListScreen
import com.khudyakov.carstore.ui.settings.SettingsScreen
import com.khudyakov.carstore.ui.theme.CarStoreTheme

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
            ListScreen()
        }
        composable("item") {
            ItemScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
