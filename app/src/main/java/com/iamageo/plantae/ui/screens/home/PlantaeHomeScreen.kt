package com.iamageo.plantae.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.iamageo.plantae.PlantaeGeneralEvents
import com.iamageo.plantae.PlantaeScreens
import com.iamageo.plantae.R
import com.iamageo.plantae.domain.model.plantsLocalDataSource
import com.iamageo.plantae.ui.theme.cottonBall
import com.iamageo.plantae.ui.theme.green
import com.iamageo.plantae.ui.theme.plantaePrimary
import kotlinx.coroutines.launch

@Composable
fun PlantaeHomeScreen(
    navController: NavController,
    viewModel: PlantaeHomeViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

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
        topBar = {},
        scaffoldState = scaffoldState
    ) {

        Column(
            modifier = Modifier
                .background(color = cottonBall)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(id = R.string.home_plant_welcome),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp)
                )
                Text(
                    text = stringResource(id = R.string.home_plant_subtitle),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp)
                )
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.plants) { plant ->
                    PlantItem(
                        plant = plant,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        onDeleteClick = {
                            viewModel.onEvent(PlantaeGeneralEvents.DeletePlant(plant))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "A planta ${plant.name} foi deletada",
                                    actionLabel = "Desfazer?"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(PlantaeGeneralEvents.RestoreDeletedPlant)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}