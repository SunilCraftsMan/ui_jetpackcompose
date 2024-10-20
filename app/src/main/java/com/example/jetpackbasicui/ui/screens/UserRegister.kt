package com.example.jetpackbasicui.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.transition.Visibility
import com.example.jetpackbasicui.data.local.room.User
import com.example.jetpackbasicui.data.repository.UserRepository
import com.example.jetpackbasicui.ui.navigation.Screen
import com.example.jetpackbasicui.viewmodel.UserRegisterViewModel

private const val TAG = "===>UserRegister"
@Composable
fun UserRegister(navController:NavHostController?=null) {
    // Get the context outside the remember block
    val viewModel: UserRegisterViewModel = hiltViewModel()
    val regName by viewModel.regName.observeAsState("")
    val regPassword by viewModel.regPassword.observeAsState("")
    val regPhone by viewModel.regPhone.observeAsState("")
    val nameErrorMesg by viewModel.nameErrorMesg.observeAsState("")
    val passwordErrorMesg by viewModel.passwordErrorMesg.observeAsState("")
    val phoneErrorMesg by viewModel.phoneErrorMesg.observeAsState("")




    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()
        .offset(y = (-10).dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Register", style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 50.dp))
        Spacer(modifier = Modifier.padding(top = 15.dp))

        TextField(value = regName, onValueChange = {viewModel.onNameChanged(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp), label = { Text(
                text = "Enter the name"
            )}, isError = nameErrorMesg.isNotEmpty())

        if (nameErrorMesg.isNotEmpty()) {
            Text(
                text = nameErrorMesg,
                color = Color.Red,  // Error text color
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 20.dp)  // Padding for the error message
            )
        }

        Spacer(modifier = Modifier.padding(top = 15.dp))

        TextField(value = regPassword, onValueChange = {viewModel.onPasswordChanged(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp), label = { Text(
                text = "Enter the password"
            )}, isError = passwordErrorMesg.isNotEmpty())

        if (passwordErrorMesg.isNotEmpty()) {
            Text(
                text = passwordErrorMesg,
                color = Color.Red,  // Error text color
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 20.dp)  // Padding for the error message
            )
        }

        Spacer(modifier = Modifier.padding(top = 15.dp))

        TextField(value = regPhone, onValueChange = {viewModel.onPhoneChanged(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp), label = { Text(
                text = "Enter the phone"
            )}, isError = phoneErrorMesg.isNotEmpty())

        if (phoneErrorMesg.isNotEmpty()) {
            Text(
                text = phoneErrorMesg,
                color = Color.Red,  // Error text color
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 20.dp)  // Padding for the error message
            )
        }

        Spacer(modifier = Modifier.padding(top = 15.dp))

        Button(onClick = { if (viewModel.validateUserInput()) {
            val user=User(username = regName, password = regPassword, phone = regPhone)
            Log.d(TAG, "UserRegister: $user")
            viewModel.storeUserData(user)
            navController?.navigate(Screen.Home.route)
        } },
            modifier = Modifier.padding(15.dp)) {
            Text(text = "Register")
        }
    }
}

@Preview
@Composable
private fun Register() {
    UserRegister()
}