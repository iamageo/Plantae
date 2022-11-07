package com.iamageo.plantae.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.iamageo.plantae.PlantaeScreens
import com.iamageo.plantae.R
import com.iamageo.plantae.domain.model.plantsLocalDataSource
import com.iamageo.plantae.ui.theme.cottonBall
import com.iamageo.plantae.ui.theme.green
import com.iamageo.plantae.ui.theme.plantaePrimary

@Composable
fun PlantaeHomeScreen(
    navController: NavController,
    viewModel: PlantaeHomeViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = PlantaeScreens.PlantAddScreen.route)
                },
                backgroundColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = green,
                    contentDescription = stringResource(id = R.string.home_add_plant_description)
                )
            }
        },
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.home_title),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = plantaePrimary)
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .background(color = cottonBall)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(plantsLocalDataSource) { plant ->
                    PlantItem(
                        plant = plant,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}