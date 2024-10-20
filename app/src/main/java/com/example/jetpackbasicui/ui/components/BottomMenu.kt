package com.example.jetpackbasicui.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackbasicui.ui.helper.BottomMenuContent
import com.example.jetpackbasicui.ui.screens.DarkMode
import com.example.jetpackbasicui.ui.screens.Explore
import com.example.jetpackbasicui.ui.screens.HomeScreen
import com.example.jetpackbasicui.ui.screens.Profile
import com.example.jetpackbasicui.ui.screens.Videos

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    activeHighlightColor: Color = Color.Gray,
    activeTextColor: Color = Color.LightGray,
    inactiveTextColor: Modifier = Modifier.blur(1.dp),
    initialSelectedItemIndex: Int = 0,
    navController: NavHostController?=null
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(Color.White) // Make sure there's a background color to see the menu
    ) {
        items.forEachIndexed { index, bottomMenuContent ->
            BottomMenuItem(
                item = bottomMenuContent,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ){
                selectedItemIndex = index
                when(bottomMenuContent.title){
                    "Home" -> navController?.navigate("home")
                    "Explore" -> navController?.navigate("explore")
                    "Dark Mode" -> navController?.navigate("dark_mode")
                }
            }
        }
    }
}

