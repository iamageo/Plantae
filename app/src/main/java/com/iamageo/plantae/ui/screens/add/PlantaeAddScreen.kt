package com.iamageo.plantae.ui.screens.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.iamageo.plantae.PlantaeUiEvents
import com.iamageo.plantae.R
import com.iamageo.plantae.ui.screens.add.components.PlantaeEditText
import com.iamageo.plantae.ui.theme.green
import com.iamageo.plantae.ui.theme.plantaePrimary
import kotlinx.coroutines.flow.collectLatest

@Composable
fun PlantaeAddScreen(
    navController: NavController,
    plantaeAddViewModel: PlantaeAddViewModel = hiltViewModel()
) {

    val plantNameState = plantaeAddViewModel.plantName.value
    val plantSpecieState = plantaeAddViewModel.plantSpecie.value
    val plantScheduleState = plantaeAddViewModel.plantSchedule.value

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        plantaeAddViewModel.eventFlow.collectLatest { event ->
            when (event) {
                is PlantaeUiEvents.ShowSnackBar -> {

                }
                is PlantaeUiEvents.SaveNewPlant -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold() { padding ->
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        plantaeAddViewModel.onEvent(PlantaeAddEvents.SaveNewPlant)
                    },
                    backgroundColor = Color.White
                ) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        tint = green,
                        contentDescription = stringResource(id = R.string.add_plant_fab)
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
                        text = "Add new plant",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = plantaePrimary)
                            .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                    )
                }
            },
            scaffoldState = scaffoldState
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                PlantaeEditText(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Plant name",
                    text = plantNameState.text,
                    backgroundColor = Color.Green,
                    onValueChange = { name ->
                        plantaeAddViewModel.onEvent(PlantaeAddEvents.EnteredPlantName(plantName = name))
                    },
                    onFocusChange = { _ -> },
                    singleLine = true,
                    keyboardType = KeyboardType.Text
                )
                PlantaeEditText(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Plant specie",
                    text = plantSpecieState.text,
                    backgroundColor = Color.Green,
                    onValueChange = { specie ->
                        plantaeAddViewModel.onEvent(PlantaeAddEvents.EnteredPlantSpecie(plantSpecie = specie))
                    },
                    onFocusChange = { _ -> },
                    singleLine = true,
                    keyboardType = KeyboardType.Text
                )
                PlantaeEditText(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Period in hours",
                    text = plantScheduleState.text,
                    backgroundColor = Color.Green,
                    onValueChange = { schedule ->
                        plantaeAddViewModel.onEvent(PlantaeAddEvents.EnteredPlantSchedule(plantSchedule = schedule.toInt()))
                    },
                    onFocusChange = { _ -> },
                    singleLine = true,
                    keyboardType = KeyboardType.Number
                )

            }
        }
    }
}