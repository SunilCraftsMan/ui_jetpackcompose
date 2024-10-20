package com.example.jetpackbasicui.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jetpackbasicui.ui.theme.JetpackBasicUITheme
import com.example.jetpackbasicui.ui.helper.CouseDatas
import com.example.jetpackbasicui.ui.components.BottomMenu
import com.example.jetpackbasicui.ui.components.ChipSection
import com.example.jetpackbasicui.ui.components.CourseSection
import com.example.jetpackbasicui.ui.components.GreetingSection
import com.example.jetpackbasicui.ui.components.SuggestionSection
import com.example.jetpackbasicui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController?=null,homeViewModel: HomeViewModel=viewModel()) {
    val context = LocalContext.current
    val bottomMenylist by homeViewModel.bottomMenuContent.observeAsState(emptyList())
    Scaffold(
        contentColor = Color.Black,
        modifier = Modifier
            .systemBarsPadding()
            .statusBarsPadding(),
        bottomBar = {
            BottomMenu(
                items = bottomMenylist,
                navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Ensures content is not hidden behind the bottom bar
        ) {
            GreetingSection()
            ChipSection(chips = listOf("Data structures", "Algorithms", "Competitive programming", "Python"))
            SuggestionSection()
            CourseSection(courses = CouseDatas(), context)
        }
    }
}

@Preview
@Composable
private fun CheckDesign() {
    JetpackBasicUITheme {
        HomeScreen()
    }
}