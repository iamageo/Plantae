package com.iamageo.plantae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iamageo.plantae.ui.screens.add.PlantaeAddScreen
import com.iamageo.plantae.ui.screens.home.PlantaeHomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = PlantaeScreens.PlantHomeScreen.route
            ) {
                composable(route = PlantaeScreens.PlantHomeScreen.route) {
                    PlantaeHomeScreen(navController = navController)
                }
                composable(route = PlantaeScreens.PlantAddScreen.route) {
                    PlantaeAddScreen(navController = navController)
                }
            }


        }
    }
}
