package com.example.jetpackbasicui.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackbasicui.R
import com.example.jetpackbasicui.ui.theme.DarkGunmetal

@Composable
fun GreetingSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Hey there", style = MaterialTheme.typography.headlineMedium)
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.search_24),
            contentDescription = "Search",
            tint = DarkGunmetal,
            modifier = Modifier.size(24.dp)
        )
    }
}