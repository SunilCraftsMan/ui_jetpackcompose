package com.example.jetpackbasicui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackbasicui.ui.screens.DarkMode
import com.example.jetpackbasicui.ui.screens.Explore
import com.example.jetpackbasicui.ui.screens.HomeScreen
import com.example.jetpackbasicui.ui.screens.Login
import com.example.jetpackbasicui.ui.screens.Profile
import com.example.jetpackbasicui.ui.screens.UserRegister
import com.example.jetpackbasicui.ui.screens.Videos

@Composable
fun Navigation() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.UserRegister.route) {
        composable(Screen.UserRegister.route){
            UserRegister(navController)
        }
        composable(Screen.Login.route) {
            Login(navController)
        }
        composable(Screen.Home.route){
            HomeScreen(navController)
        }
        composable(Screen.Explore.route){
            Explore(navController)
        }
        composable(Screen.DarkMode.route){
            DarkMode(navController)
        }
        composable(Screen.Videos.route){
            Videos(navController)
        }
        composable(Screen.Profile.route){
            Profile(navController)
        }
    }
}