package com.example.jetpackbasicui.ui.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun Explore(navController: NavHostController ?= null) {
    val context= LocalContext.current
    Toast.makeText(context, "Explore", Toast.LENGTH_SHORT).show()
}