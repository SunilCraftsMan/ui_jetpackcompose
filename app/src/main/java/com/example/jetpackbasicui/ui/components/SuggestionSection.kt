package com.example.jetpackbasicui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackbasicui.R
import com.example.jetpackbasicui.ui.theme.DarkGunmetal

@Composable
fun SuggestionSection() {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DarkGunmetal)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()){
        Column {
            Text(text = "Daily Coding", style = MaterialTheme.typography.headlineSmall, color = Color.White)
            Text(text = "do at least • 3-10 problems / day",
                style = MaterialTheme.typography.bodyMedium, color = Color.White)
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color = Color.LightGray)
            .padding(10.dp)) {
            Icon(painter = painterResource(id = R.drawable.play_circle_24), contentDescription = "Play",
                tint = Color.White, modifier = Modifier.size(25.dp))
        }
    }
}