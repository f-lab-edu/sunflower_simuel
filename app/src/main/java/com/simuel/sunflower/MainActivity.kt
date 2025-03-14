package com.simuel.sunflower

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simuel.sunflower.feature.home.HomeScreen
import com.simuel.sunflower.feature.plantdetail.PlantDetailScreen
import com.simuel.sunflower.ui.theme.SunflowerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SunflowerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SunflowerApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SunflowerApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                modifier = modifier,
                onPlantDetailClick = { plantId ->
                    navController.navigate("plantDetail/$plantId")
                }
            )
        }
        composable("plantDetail/{plantId}") { backStackEntry ->
            PlantDetailScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}