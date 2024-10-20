package com.example.jetpackbasicui.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackbasicui.ui.helper.BottomMenuContent
import com.example.jetpackbasicui.ui.theme.LightGreen1

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean,
    activeHighlightColor: Color,
    activeTextColor: Color,
    inactiveTextColor: Modifier,
    onItemClick: () -> Unit
) {
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .padding(10.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(
                if (isSelected) LightGreen1
                else Color.Transparent
            )){
            Icon(painter = painterResource(id = item.iconId), contentDescription = item.title, modifier = Modifier.size(20.dp))
        }

        Text(text = item.title, style = MaterialTheme.typography.bodySmall, color = Color.Black)
    }
}