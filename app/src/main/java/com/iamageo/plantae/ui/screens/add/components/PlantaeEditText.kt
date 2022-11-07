package com.iamageo.plantae.ui.screens.add.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PlantaeEditText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    backgroundColor: Color,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    onFocusChange: (FocusState) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        val lightBlue = Color(0xffd8e6ff)

        Text(
            text = label,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
                .onFocusChanged { onFocusChange },
            textAlign = TextAlign.Start,
            color = Color.Black
        )
        TextField(
            modifier = modifier,
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor.copy(alpha = 0.1f),
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = onValueChange,
            shape = RoundedCornerShape(8.dp),
            singleLine = singleLine,
        )
    }
}