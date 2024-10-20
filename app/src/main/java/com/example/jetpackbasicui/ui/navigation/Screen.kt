package com.example.jetpackbasicui.ui.navigation

import androidx.transition.Scene

sealed class Screen(val route:String) {
    data object UserRegister:Screen("register")
    data object Login:Screen("login")
    data object Home:Screen("home")
    data object Explore:Screen("explore")
    data object DarkMode:Screen("dark_mode")
    data object Videos:Screen("videos")
    data object Profile:Screen("profile")
}