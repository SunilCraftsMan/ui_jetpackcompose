package com.example.jetpackbasicui.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackbasicui.ui.helper.Course

@Composable
fun CourseSection(courses: List<Course>, context: Context) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Courses", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(15.dp))
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 7.5.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(courses.size) { CourseItem (courses[it],context) }
    }
}