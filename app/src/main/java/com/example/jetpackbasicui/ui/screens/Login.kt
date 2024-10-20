package com.example.jetpackbasicui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackbasicui.ui.navigation.Screen

@Composable
fun Login(navController: NavHostController? = null) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var usernameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }


    fun validateUserInput(username: String, password: String): Boolean {
        var isValid = true

        // Username validation
        if (username.isEmpty()) {
            usernameError = "Username cannot be empty."
            isValid = false
        } else if (username.length < 4) {
            usernameError = "Username must be at least 4 characters long."
            isValid = false
        } else if (username.contains(" ")) {
            usernameError = "Username cannot contain spaces."
            isValid = false
        }

        // Password validation
        if (password.isEmpty()) {
            passwordError = "Password cannot be empty."
            isValid = false
        } else if (password.length < 6) {
            passwordError = "Password must be at least 6 characters long."
            isValid = false
        }

        return isValid
    }


    Column(

        modifier = Modifier
            .statusBarsPadding()
            .offset(y = (-50).dp)
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,  // Centers content vertically
        horizontalAlignment = Alignment.CenterHorizontally  // Centers content horizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(bottom = 50.dp)  // Adds space below the text
        )

        // Username TextField
        TextField(
            value = userName,
            onValueChange = { newValue -> userName = newValue },
            label = { Text(text = "Enter the username:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            isError = usernameError.isNotEmpty()
        )

        if (usernameError.isNotEmpty()) {
            Text(
                text = usernameError,
                color = Color.Red,  // Error text color
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 20.dp)  // Padding for the error message
            )
        }

        Spacer(modifier = Modifier.height(16.dp))  // Space between TextFields

        // Password TextField
        TextField(
            value = password,
            onValueChange = { newValue -> password = newValue },
            label = { Text(text = "Enter the password:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            isError = passwordError.isNotEmpty()
        )
        if (passwordError.isNotEmpty()) {
            Text(
                text = passwordError,
                color = Color.Red,  // Error text color
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 20.dp)  // Padding for the error message
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (validateUserInput(userName, password)) {
                navController?.navigate(Screen.Home.route)
            }
        }, modifier = Modifier
            .padding(15.dp)
            .clip(shape = CutCornerShape(12.dp))) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    Login()
}