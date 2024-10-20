package com.example.jetpackbasicui.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackbasicui.ui.theme.DarkGunmetal

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(modifier = Modifier.padding(end = 10.dp)) {
        itemsIndexed(chips){index,chip->
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = index
                    }
                    .then(
                        if (selectedChipIndex != index) Modifier.border(
                            BorderStroke(
                                1.dp,
                                color = Color.Black
                            )
                        )
                        else Modifier
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == index) DarkGunmetal
                        else Color.Unspecified
                    )
                    .padding(15.dp)
            ){
                Text(text = chip, color = if (selectedChipIndex == index) Color.White
                else Color.Unspecified, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}