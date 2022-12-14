package com.iamageo.plantae.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamageo.plantae.R
import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.ui.theme.annapolosBlue
import com.iamageo.plantae.ui.theme.green
import com.iamageo.plantae.ui.theme.veiledSpotlight

@Composable
fun PlantItem(
    plant: Plant,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit
) {

    Spacer(modifier = Modifier.height(44.dp))
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.4f)
                ) {

                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                ) {
                    Text(
                        text = plant.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = annapolosBlue,
                    )
                    Text(
                        text = plant.type,
                        fontSize = 12.sp,
                        color = veiledSpotlight,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Schedule: ${plant.schedule}",
                        fontSize = 12.sp,
                        color = veiledSpotlight,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,

                        ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                tint = green,
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(onClick = onDeleteClick) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                tint = Color.Black,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }

        }
        Card(
            modifier = Modifier
                .offset(16.dp, (-44).dp)
                .fillMaxWidth(0.3f)
                .height(164.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
            )
        }
    }

}