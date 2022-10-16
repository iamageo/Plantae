package com.iamageo.plantae.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iamageo.plantae.R
import com.iamageo.plantae.domain.model.plantsLocalDataSource

@Composable
fun PlantaeHomeScreen(
    navController: NavController,
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = MaterialTheme.colors.secondary,
                    contentDescription = stringResource(id = R.string.home_add_plant_description)
                )
            }
        },
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.home_title),
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(plantsLocalDataSource) { plant ->
                    PlantItem(
                        plant = plant,
                        modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth()
                    )
                }
            }
        }
    }
}