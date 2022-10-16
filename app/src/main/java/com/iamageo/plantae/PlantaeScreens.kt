package com.iamageo.plantae

sealed class PlantaeScreens(val route: String) {
    object PlantHomeScreen: PlantaeScreens("plantae_home_screen")
}