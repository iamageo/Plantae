package com.iamageo.plantae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iamageo.plantae.ui.screens.home.PlantHomeScreen
import com.iamageo.plantae.ui.theme.PlantaeTheme

class PlantMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PlantaeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = PlantaeScreens.PlantHomeScreen.route
                    ) {
                        composable(route = PlantaeScreens.PlantHomeScreen.route) {
                            PlantHomeScreen(navController = navController)
                        }
                    }
                }
            }

        }
    }
}
